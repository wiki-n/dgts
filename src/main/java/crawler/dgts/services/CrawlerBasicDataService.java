package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crawler.dgts.dto.DCMResponse;
import crawler.dgts.dto.DistrictDto;
import crawler.dgts.dto.ProvinceDto;
import crawler.dgts.utils.AppConstant;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CrawlerBasicDataService {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private DgtsService dgtsService; 
	
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
			districts = dgtsService.getDistrictByProvinceCode(province.getCode());
			districtDtos.addAll(districts);
		});
		return districtService.saveDistricts(districtDtos);		
	}
}
