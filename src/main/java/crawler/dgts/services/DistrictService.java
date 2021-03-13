package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import crawler.dgts.dto.DCMResponse;
import crawler.dgts.dto.DistrictDto;
import crawler.dgts.entity.District;
import crawler.dgts.repository.DistrictRepository;
import crawler.dgts.utils.AppConstant;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DistrictService {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private DistrictRepository districtRepository;
	public DCMResponse saveDistricts(List<DistrictDto> districtDtos) {
		DCMResponse result = new DCMResponse(AppConstant.ERROR_CODE.OK);
		if(districtDtos.isEmpty()) {
			return result;
		}
		List<District> districts = new ArrayList<>();
		districtDtos.forEach(dto ->{
			districts.add(convertDto2Entity(dto));
		});
		try {
			districtRepository.saveAll(districts);
			log.info("DistrictService saveDistricts Succeed to save ", districts);
		} catch (IllegalArgumentException e) {
			log.info("DistrictService saveDistricts Failed to save ", districts);
			result = new DCMResponse(AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	private District convertDto2Entity(DistrictDto dto) {
		if(dto == null ) return new District();
		District entity = new District();
		entity.setCode(dto.getId());
		entity.setName(dto.getName());
		entity.setProvinceCode(dto.getParentId());
		return entity;
	}
}
