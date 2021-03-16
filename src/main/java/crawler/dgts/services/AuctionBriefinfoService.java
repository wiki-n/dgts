package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crawler.dgts.dto.AuctionBriefInfoDto;
import crawler.dgts.dto.AuctionPropertyInfoDto;
import crawler.dgts.dto.DCMResponse;
import crawler.dgts.entity.AuctionBriefInfo;
import crawler.dgts.repository.AuctionBriefRepository;
import crawler.dgts.services.common.BaseClientService;
import crawler.dgts.utils.AppConstant;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuctionBriefinfoService  extends BaseClientService {
	@Autowired
	private AuctionBriefRepository auctionBriefRepository;
	public DCMResponse saveAuctionBriefInfo(List<AuctionBriefInfoDto> auctBriefs) {
		DCMResponse response = new DCMResponse(AppConstant.ERROR_CODE.OK); 
		if(auctBriefs.isEmpty()) {
			return response;
		}
		List<AuctionBriefInfo> briefEntyties = new ArrayList<>();
		auctBriefs.forEach(auctBrief ->{
			briefEntyties.add(convertDto2Entity(auctBrief));
		});
		try {
			auctionBriefRepository.saveAll(briefEntyties);
		} catch (IllegalArgumentException e) {
			log.info("AuctionBriefinfoService saveAuctionBriefInfo error ", e);
			log.info("AuctionBriefinfoService saveAuctionBriefInfo error ", briefEntyties);
			response = new DCMResponse(AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	private AuctionBriefInfo convertDto2Entity(AuctionBriefInfoDto dto) {
		AuctionBriefInfo entity = new AuctionBriefInfo();
		if(dto == null) {
			return entity;
		}
		entity = objectMapper.convertValue(dto, AuctionBriefInfo.class);
		entity.setAuctionInfoId(dto.getId());
		entity.setId(null);
		entity.setLinkLocation(convertAucNoticeLinkFromDto(dto));
		return entity;
	}
	private AuctionBriefInfoDto convertEntity2Dto(AuctionBriefInfo entity) {
		AuctionBriefInfoDto dto = new AuctionBriefInfoDto();
		if(entity == null) {
			return dto;
		}
		dto = objectMapper.convertValue(entity, AuctionBriefInfoDto.class);
		return dto;
	}
	private String convertAucNoticeLinkFromDto(AuctionBriefInfoDto dto) {
		String link = "";
		//TODO remove Accent, build the link as bellow rule
		/*
		 * var name = convertStringToEnglish(propertyName); var redrUrl = preUrl +
		 * "/thong-bao-cong-khai-viec-dau-gia/" + name + "-" + id + ".html";
		 */

		return link;
	}
}
