package crawler.dgts.services;

import org.springframework.stereotype.Service;

import crawler.dgts.dto.AuctionPropertyInfoDto;
import crawler.dgts.entity.AuctionPropertyInfo;
import crawler.dgts.services.common.BaseClientService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AuctionPropertyInfoService extends BaseClientService {

	private AuctionPropertyInfo convertDto2Entity(AuctionPropertyInfoDto dto) {
		AuctionPropertyInfo entity = new AuctionPropertyInfo();
		entity = objectMapper.convertValue(dto, AuctionPropertyInfo.class);
		return entity;
	}
	private AuctionPropertyInfoDto convertEntity2Dto(AuctionPropertyInfo entity) {
		AuctionPropertyInfoDto dto = new AuctionPropertyInfoDto();
		dto = objectMapper.convertValue(entity, AuctionPropertyInfoDto.class);
		return dto;
	}

}
