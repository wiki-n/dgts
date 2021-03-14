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

import crawler.dgts.dto.DistrictDto;
import crawler.dgts.services.common.BaseClientService;
import crawler.http.context.HttpContext;
import crawler.http.context.HttpResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DgtsService extends BaseClientService {
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
	public List<DistrictDto> getDistrictByProvinceCode(int provinceCode){
		List<DistrictDto> districts = new ArrayList<>();
		String url = String.format("%s/getListDistrict", dgtsServiceCommon);
		Map<String, String> headers = new HashMap<>();
		Map<String, String> requestParams = new HashMap<>();
		headers.put("Accept", "application/json, text/plain, */*");
		requestParams.put("province", String.valueOf(provinceCode));
		try {
			HttpResponse response = httpContext.getHttpUtil().get(url, headers, requestParams);
			if(response != null && response.isOk()) {
				String responseString = new String(response.getBody(),"UTF8");
				districts = objectMapper.readValue(responseString, new TypeReference<List<DistrictDto>>() {
				});
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return districts;
	}
}
