package crawler.dgts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import crawler.dgts.dto.ProvinceDto;
import crawler.dgts.entity.Province;
import crawler.dgts.repository.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProvinceService {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProvinceRepository provinceRepository;

	public List<ProvinceDto> findAllProvince() {
		List<Province> provinces = (List<Province>) provinceRepository.findAll();
		List<ProvinceDto> provinceDtos = new ArrayList<>();
		if (!provinces.isEmpty()) {
			provinces.forEach(province -> {
				provinceDtos.add(convertEntityToDto(province));
			});
		}
		log.info("ProvinceService findAllProvince result: "+ provinceDtos);
		return provinceDtos;
	}

	private ProvinceDto convertEntityToDto(Province entity) {
		ProvinceDto dto = new ProvinceDto();
		if (entity != null) {
			dto = objectMapper.convertValue(entity, ProvinceDto.class);
		}
		return dto;
	}

	private Province convertDtoToEntity(ProvinceDto dto) {
		if (dto == null)
			return new Province();
		Province entity = objectMapper.convertValue(dto, Province.class);
		return entity;
	}
}
