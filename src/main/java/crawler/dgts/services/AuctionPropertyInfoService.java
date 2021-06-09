package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import crawler.dgts.dto.AuctionPropertyFullInfoDto;
import crawler.dgts.entity.AuctionPropertyFullInfo;
import crawler.dgts.repository.AuctionPropertyFullInfoRepository;
import crawler.dgts.services.common.BaseClientService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AuctionPropertyInfoService extends BaseClientService {

	@Autowired
	private AuctionPropertyFullInfoRepository auctionPropertyFullInfoRepository;
	private AuctionPropertyFullInfo convertDto2Entity(AuctionPropertyFullInfoDto dto) {
		AuctionPropertyFullInfo entity = new AuctionPropertyFullInfo();
		entity = objectMapper.convertValue(dto, AuctionPropertyFullInfo.class);
		return entity;
	}
	private AuctionPropertyFullInfoDto convertEntity2Dto(AuctionPropertyFullInfo entity) {
		AuctionPropertyFullInfoDto dto = new AuctionPropertyFullInfoDto();
//		dto = objectMapper.convertValue(entity, AuctionPropertyFullInfoDto.class);
		dto.setAuctionPropertyInfoId(entity.getAuctionPropertyInfoId());
		dto.setAuctionInfoId(entity.getAuctionInfoId());
		dto.setPublishTime1(entity.getPublishTime1());
		dto.setAucTime(entity.getAucTime());
		dto.setAucRegTimeStart(entity.getAucRegTimeStart());
		dto.setAucRegTimeEnd(entity.getAucRegTimeEnd());
		dto.setLinkLocation(entity.getLinkLocation());
		dto.setPropertyName(entity.getPropertyName());
		dto.setPropertyAmount(entity.getPropertyAmount());
		dto.setPropertyStartPrice(entity.getPropertyStartPrice());
		dto.setDetail(entity.getDetail());
		dto.setPropertyQuality(entity.getPropertyQuality());
		dto.setDeposit(entity.getDeposit());
		dto.setDepositUnit(entity.getDepositUnit());
		dto.setPropertyTypeId(entity.getPropertyTypeId());
		dto.setPropertyPlace(entity.getPropertyPlace());
		dto.setFileCost(entity.getFileCost());
//		if(!CollectionUtils.isEmpty(entity.getTagInfo())) {
//			List<String> tags = new ArrayList<>();
//			entity.getTagInfo().forEach(tag ->{
//				tags.add(tag.getTag());
//			});
//			dto.setTags(tags);
//		}
		return dto;
	}
	public List<AuctionPropertyFullInfoDto> getUnprocessAuctionProperty(Integer max){
		 List<AuctionPropertyFullInfoDto> unprocessedAuctionProperties = new ArrayList<>();
		 List<AuctionPropertyFullInfo> unprocessedList = (List<AuctionPropertyFullInfo>) auctionPropertyFullInfoRepository.findUnprocessRecords(max);
		 if(!CollectionUtils.isEmpty(unprocessedList)) {
			 for(AuctionPropertyFullInfo entity : unprocessedList) {
				 AuctionPropertyFullInfoDto dto = this.convertEntity2Dto(entity);
				 unprocessedAuctionProperties.add(dto);
				 max--;
				 if(max < 1) break;
			 };
		 }
		return unprocessedAuctionProperties;
	}
}
