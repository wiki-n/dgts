package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import crawler.dgts.dto.AuctionBriefInfoDto;
import crawler.dgts.dto.AuctionPropertySpecifiedInfoDto;
import crawler.dgts.dto.AuctionSearchInput;
import crawler.dgts.dto.AuctionSearchResult;
import crawler.dgts.dto.DCMResponse;
import crawler.dgts.dto.DistrictDto;
import crawler.dgts.dto.ProvinceDto;
import crawler.dgts.services.common.BaseClientService;
import crawler.dgts.utils.AppConstant;
import crawler.http.context.HttpContext;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CrawlAuctionDataService extends BaseClientService {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private AuctionService auctionService;
	@Autowired
	private AuctionBriefinfoService auctionBriefinfoService;
	@Autowired
	private AuctionPropertySpecifiedService auctionPropertySpecifiedService;

	public DCMResponse cloneAllDistrictsDtgs() {
		DCMResponse response = new DCMResponse(AppConstant.ERROR_CODE.OK);
		List<ProvinceDto> provinceDtos = provinceService.findAllProvince();
		List<DistrictDto> districtDtos = new ArrayList<>();
		if (provinceDtos.isEmpty()) {
			log.info("CrawlerBasicDataService cloneAllDistrictsDtgs empty provinces");
			return response;
		}
		provinceDtos.forEach(province -> {
			List<DistrictDto> districts = new ArrayList<>();
			districts = auctionService.getDistrictByProvinceCode(province.getCode());
			districtDtos.addAll(districts);
		});
		return districtService.saveDistricts(districtDtos);
	}

	public List<AuctionBriefInfoDto> getAuctionBrief(AuctionSearchInput searchInput) {
		List<AuctionBriefInfoDto> aucBriefInfos = new ArrayList<>();
		AuctionSearchResult result = auctionService.getAuctionNoticeList(searchInput);
		if (result == null || result.getItems() == null) {
			return aucBriefInfos;
		}
		aucBriefInfos
				.addAll(objectMapper.convertValue(result.getItems(), new TypeReference<List<AuctionBriefInfoDto>>() {
				}));
		auctionBriefinfoService.saveAuctionBriefInfo(aucBriefInfos);
		Integer pageCount = result.getPageCount();
		for (int p = Integer.valueOf(searchInput.getP()).intValue() + 1; p <= pageCount; p++) {
			aucBriefInfos.clear();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				log.info("CrawlAuctionDataService getAuctionBrief sleep error " + e);
			}
			searchInput.setP(String.valueOf(p));
			result = auctionService.getAuctionNoticeList(searchInput);
			if (result != null && result.getItems() != null) {
				aucBriefInfos.addAll(
						objectMapper.convertValue(result.getItems(), new TypeReference<List<AuctionBriefInfoDto>>() {
						}));
				auctionBriefinfoService.saveAuctionBriefInfo(aucBriefInfos);
			} else {
				p--; // retry
			}

		}
//		auctionBriefinfoService.saveAuctionBriefInfo(aucBriefInfos);
		return aucBriefInfos;
	}

	public DCMResponse getAuctionFull(AuctionSearchInput searchInput) {
		DCMResponse response = new DCMResponse(AppConstant.ERROR_CODE.OK);
		return response;
	}

	public DCMResponse cloneAuctionDetails(Integer totalRecords, Integer processNumber) {
		// Read AuctionBriefInfo database order by publishTime1. Process a batch of 10
		// to avoid loss data due to network, crash issue.
		// Request to get detail for each AuctionBriefInfo
		// convert to entities and save
		// update process_status
		// repeat
		DCMResponse response = new DCMResponse(AppConstant.ERROR_CODE.OK);
		if (totalRecords == null || totalRecords < 1) {
			return response;
		}
		if (processNumber == null || processNumber < 1) {
			return response;
		}
		Integer beginIndex = 1, endIndex = processNumber;
		Integer currentNumber = 0;
		while (true) {
			List<AuctionPropertySpecifiedInfoDto> auctions = new ArrayList<>();
			List<Integer> processAuctionInfoIds = new ArrayList<>();
			List<Integer> auctionInfoIds = auctionBriefinfoService.getUnprocessAuctionInfoIds(beginIndex, endIndex);
			if (auctionInfoIds != null && !auctionInfoIds.isEmpty()) {
				HttpContext oneTimeHttpContext = new HttpContext();
				auctionInfoIds.forEach(auctionInfoId -> {
					List<AuctionPropertySpecifiedInfoDto> returnAuctions = new ArrayList<>();
					returnAuctions = auctionService.getAuctionSpecifiedInfoByAuctionId(oneTimeHttpContext,auctionInfoId);
					if (!returnAuctions.isEmpty()) {
						auctions.addAll(returnAuctions);
						processAuctionInfoIds.add(auctionInfoId);
						log.info("CrawlAuctionDataService cloneAuctionDetails auctionInfoId " + auctionInfoId);
						
					}

				});
				auctionPropertySpecifiedService.saveAllAuctionPropertySpecified(auctions);
				auctionBriefinfoService.updateProcessStatus(processAuctionInfoIds);
				currentNumber = currentNumber + processAuctionInfoIds.size();
				log.info("CrawlAuctionDataService cloneAuctionDetails endIndex " + currentNumber + "/totalRecords "
						+ totalRecords);
				oneTimeHttpContext.getHttpUtil().close();
			} else { // no more unprocess records
				break;
			}
		}
		log.info("CrawlAuctionDataService cloneAuctionDetails finised clone info for totalRecords "
				+ totalRecords);
		return response;
	}
}
