package crawler.dgts.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import crawler.dgts.dto.AuctionBriefInfoDto;
import crawler.dgts.dto.AuctionPropertySpecifiedInfoDto;
import crawler.dgts.dto.AuctionSearchInput;
import crawler.dgts.dto.AuctionSearchResult;
import crawler.dgts.dto.DistrictDto;
import crawler.dgts.services.common.BaseClientService;
import crawler.dgts.utils.JsonService;
import crawler.http.context.HttpContext;
import crawler.http.context.HttpResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuctionService extends BaseClientService {
	@Value("${dgts.service.common}")
	private String dgtsServiceCommon;

	@Value("${dgts.service.portal}")
	private String dgtsServicePortal;

	@Autowired
	HttpContext httpContext;

	@Override
	protected HttpHeaders getHeaders() {
		HttpHeaders headers = super.getHeaders();
		headers.set(CONTENT_TYPE, "application/json");
		return headers;
	}

	public List<DistrictDto> getDistrictByProvinceCode(int provinceCode) {
		List<DistrictDto> districts = new ArrayList<>();
		String url = String.format("%s/getListDistrict", dgtsServiceCommon);
		Map<String, String> headers = new HashMap<>();
		Map<String, String> requestParams = new HashMap<>();
		headers.put("Accept", "application/json, text/plain, */*");
		requestParams.put("province", String.valueOf(provinceCode));
		try {
			HttpResponse response = httpContext.getHttpUtil().get(url, headers, requestParams);
			if (response != null && response.isOk()) {
				String responseString = new String(response.getBody(), "UTF8");
				districts = objectMapper.readValue(responseString, new TypeReference<List<DistrictDto>>() {
				});
			}
		} catch (IOException e) {
			log.info("DgtsService getDistrictByProvinceCode failed " + e);
		}
		return districts;
	}

	// search Auction Brief as search condition
	public AuctionSearchResult getAuctionNoticeList(AuctionSearchInput searchInput) {
		AuctionSearchResult result = new AuctionSearchResult();
		HttpContext oneTimeHttpContext = new HttpContext();
		String url = String.format("%s/search/auction-notice", dgtsServicePortal);
		Map<String, String> headers = new HashMap<>();
		Map<String, String> requestParams = new HashMap<>();
		headers.put("Accept", "application/json, text/plain, */*");
		requestParams.put("endDate", searchInput.getEndDate());
		requestParams.put("endPublishDate", searchInput.getEndPublishDate());
		requestParams.put("numberPerPage", searchInput.getNumberPerPage());
		requestParams.put("p", searchInput.getP());
		requestParams.put("provinceId", searchInput.getProvinceId());
		requestParams.put("searchSimple", searchInput.getSearchSimple());
		requestParams.put("selectedOrganizationId", searchInput.getSelectedOrganizationId());
		requestParams.put("startDate", searchInput.getStartDate());
		requestParams.put("startPublishDate", searchInput.getStartPublishDate());
		try {
			HttpResponse response = oneTimeHttpContext.getHttpUtil().get(url, headers, requestParams);
			if (response != null && response.isOk()) {
				String responseString = new String(response.getBody(), "UTF8");
				result = objectMapper.readValue(responseString, AuctionSearchResult.class);
				if (result != null) {
					log.info("DgtsService getAuctionNoticeList page " + searchInput.getP() + "/ total "
							+ result.getPageCount());
				}
			}
		} catch (IOException e) {
			log.info("DgtsService getAuctionNoticeList failed " + e);
		}
		oneTimeHttpContext.getHttpUtil().close();
		return result;
	}

	// get Auction Full Info by AuctionId
	public List<AuctionPropertySpecifiedInfoDto> getAuctionSpecifiedInfoByAuctionId(HttpContext oneTimeHttpContext, Integer aucId) {
		List<AuctionPropertySpecifiedInfoDto> auctions = new ArrayList<>();
		AuctionSearchResult result = new AuctionSearchResult();
//		HttpContext oneTimeHttpContext = new HttpContext();
		String url = String.format("%s/propertyInfo", dgtsServicePortal);
		Map<String, String> headers = new HashMap<>();
		Map<String, String> requestParams = new HashMap<>();
		headers.put("Accept", "application/json, text/plain, */*");
		requestParams.put("auctionInfoId", String.valueOf(aucId));
		try {
			HttpResponse response = oneTimeHttpContext.getHttpUtil().get(url, headers, requestParams);
			if (response != null && response.isOk()) {
				String responseString = new String(response.getBody(), "UTF8");
				result = objectMapper.readValue(responseString, AuctionSearchResult.class);
				if (!result.getItems().isEmpty()) {
					auctions.addAll(objectMapper.convertValue(result.getItems(),
							new TypeReference<List<AuctionPropertySpecifiedInfoDto>>() {
							}));
//					log.info("DgtsService getAuctionSpecifiedInfoById aution info auction Id "+ auctions);
				} else {
					log.info("DgtsService getAuctionSpecifiedInfoById empty info auction Id " + aucId);
				}
			}
		} catch (IOException e) {
			log.info("DgtsService getDistrictByProvinceCode failed " + e);
		}
//		oneTimeHttpContext.getHttpUtil().close();
		return auctions;
	}
}
