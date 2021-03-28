package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crawler.dgts.dto.AuctionPropertySpecifiedInfoDto;
import crawler.dgts.dto.DCMResponse;
import crawler.dgts.entity.AuctionPropertySpecifiedInfo;
import crawler.dgts.repository.AuctionPropertySpecifiedRepository;
import crawler.dgts.services.common.BaseClientService;
import crawler.dgts.utils.AppConstant;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuctionPropertySpecifiedService extends BaseClientService {
	@Autowired
	private AuctionPropertySpecifiedRepository auctionPropertySpecifiedRepository;

	private AuctionPropertySpecifiedInfo convertDto2Entity(AuctionPropertySpecifiedInfoDto dto) {
		AuctionPropertySpecifiedInfo entity = new AuctionPropertySpecifiedInfo();
		entity = objectMapper.convertValue(dto, AuctionPropertySpecifiedInfo.class);
		if(StringUtils.isBlank(dto.getPropertyName())) {
			entity.setPropertyName("Not Found");
			}
		return entity;
	}

	private AuctionPropertySpecifiedInfoDto convertEntity2Dto(AuctionPropertySpecifiedInfo entity) {
		AuctionPropertySpecifiedInfoDto dto = new AuctionPropertySpecifiedInfoDto();
		dto = objectMapper.convertValue(entity, AuctionPropertySpecifiedInfoDto.class);
		return dto;
	}

	public DCMResponse saveAllAuctionPropertySpecified(
			List<AuctionPropertySpecifiedInfoDto> auctionPropertySpecifiedInfos) {
		DCMResponse response = new DCMResponse(AppConstant.ERROR_CODE.OK);
		if (auctionPropertySpecifiedInfos.isEmpty()) {
			return response;
		}
		List<AuctionPropertySpecifiedInfo> auctionEntyties = new ArrayList<>();
		auctionPropertySpecifiedInfos.forEach(auctInfo -> {
			auctionEntyties.add(convertDto2Entity(auctInfo));
		});
		// remove existed, duplicated records before save base on link, auction_info_id
		List<AuctionPropertySpecifiedInfo> dictinctAuctionEntyties = auctionEntyties.stream().distinct()
				.collect(Collectors.toList());
		try {
			auctionPropertySpecifiedRepository.saveAll(dictinctAuctionEntyties);
		} catch (IllegalArgumentException e) {
			log.info("AuctionBriefinfoService saveAuctionBriefInfo error " + e);
			log.info("AuctionBriefinfoService saveAuctionBriefInfo error " + dictinctAuctionEntyties);
			response = new DCMResponse(AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
