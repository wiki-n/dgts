package crawler.dgts.services;

import org.springframework.stereotype.Service;

import crawler.dgts.dto.AuctionPropertySpecifiedInfoDto;
import crawler.dgts.entity.AuctionPropertySpecifiedInfo;
import crawler.dgts.services.common.BaseClientService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuctionPropertySpecifiedService extends BaseClientService {
	private AuctionPropertySpecifiedInfo convertDto2Entity(AuctionPropertySpecifiedInfoDto dto) {
		AuctionPropertySpecifiedInfo entity = new AuctionPropertySpecifiedInfo();
		entity = objectMapper.convertValue(dto, AuctionPropertySpecifiedInfo.class);
		return entity;
	}

	private AuctionPropertySpecifiedInfoDto convertEntity2Dto(AuctionPropertySpecifiedInfo entity) {
		AuctionPropertySpecifiedInfoDto dto = new AuctionPropertySpecifiedInfoDto();
		dto = objectMapper.convertValue(entity, AuctionPropertySpecifiedInfoDto.class);
		return dto;
	}
}
