package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import crawler.dgts.dto.AuctionBriefInfoDto;
import crawler.dgts.dto.AuctionSearchInput;
import crawler.dgts.dto.AuctionSearchResult;
import crawler.dgts.dto.DCMResponse;
import crawler.dgts.dto.DistrictDto;
import crawler.dgts.dto.ProvinceDto;
import crawler.dgts.services.common.BaseClientService;
import crawler.dgts.utils.AppConstant;
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
		if(provinceDtos.isEmpty()) {
			log.info("CrawlerBasicDataService cloneAllDistrictsDtgs empty provinces");
			return response;
		}
		provinceDtos.forEach(province ->{
			List<DistrictDto> districts = new ArrayList<>();
			districts = auctionService.getDistrictByProvinceCode(province.getCode());
			districtDtos.addAll(districts);
		});
		return districtService.saveDistricts(districtDtos);		
	}
	
	public List<AuctionBriefInfoDto> getAuctionBrief(AuctionSearchInput searchInput) {
		List<AuctionBriefInfoDto> aucBriefInfos = new ArrayList<>(); 
		AuctionSearchResult result = auctionService.getAuctionNoticeList(searchInput);
		if(result == null || result.getItems() == null) {
			return aucBriefInfos;
		}
		aucBriefInfos.addAll(objectMapper.convertValue(result.getItems(), new TypeReference<List<AuctionBriefInfoDto>>() { }));
		Integer pageCount = result.getPageCount();
		for(int p = 2; p <= pageCount; p++) {
			searchInput.setP(String.valueOf(p));
			result = auctionService.getAuctionNoticeList(searchInput);
			aucBriefInfos.addAll(objectMapper.convertValue(result.getItems(), new TypeReference<List<AuctionBriefInfoDto>>() { }));
		}
		auctionBriefinfoService.saveAuctionBriefInfo(aucBriefInfos);
		return aucBriefInfos;
	}

	public DCMResponse getAuctionFull(AuctionSearchInput searchInput) {
		DCMResponse response = new DCMResponse(AppConstant.ERROR_CODE.OK);
		return response;
	}
}
