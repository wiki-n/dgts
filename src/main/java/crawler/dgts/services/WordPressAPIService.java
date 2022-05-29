package crawler.dgts.services;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import crawler.dgts.dto.WordpressPost;
import crawler.dgts.services.common.BaseClientService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WordPressAPIService extends BaseClientService {
	@Value("${wordpress.service.url}")
	private String wpServiceUrl;

	@Value("${wordpress.service.pass}")
	private String wpPass;

	@Value("${wordpress.service.path.post}")
	private String pathPost;
	
	@Value("${wordpress.service.path.tag}")
	private String pathTag;
	@Override
	protected HttpHeaders getHeaders() {
		HttpHeaders headers = super.getHeaders();
		headers.set(CONTENT_TYPE, "application/json; charset=UTF-8");
//		header('Content-type: text/html; charset=ISO-8859-1');
		headers.set(AUTHORIZATION, wpPass);
		;
		return headers;
	}

	// password for hoangpd application: MFiT wnKl YTM6 bNAN iuHC VJwP
	/*
	 * curl -L -X POST
	 * 'http://localhost:8000/wp-json/wp/v2/posts?title=Test%20title%202%202&content
	 * =test%20content&tags=1&status=publish' -H 'Authorization: Basic
	 * aG9hbmdfZGV2Ok1GaVQgd25LbCBZVE02IGJOQU4gaXVIQyBWSndQ'
	 */
	public Map<Integer,String> createPost(Integer aucPropertyId, WordpressPost post) {
		Map<Integer,String> result = new HashMap<>();
		String link = null;
		RestTemplate restTemplate = getRestTemplate();
		
		UriComponents  builder = UriComponentsBuilder.fromHttpUrl(wpServiceUrl).path(pathPost)
		        .queryParam("title", post.getTittle())
		        .queryParam("content", post.getContent())
		        .queryParam("tags", 1)
		        .queryParam("status", "publish").build();

		HttpEntity<?> entity = new HttpEntity<>(getHeaders());

		URI endpoint = builder.toUri();

		log.info("With Endpoint {} ", endpoint);
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					endpoint, 
			        HttpMethod.POST, 
			        entity, 
			        String.class);
			
			JSONObject json;
			try {
				json = new JSONObject(response.getBody());
				link = json.getString("link");
			} catch (JSONException e) {
				log.error("Call API " + endpoint + " FAIL. " + e);
			}
		} catch (HttpClientErrorException e) {
			log.error("Call API " + endpoint + " FAIL. " + e.getResponseBodyAsString());
			throw new RuntimeException("Call API " + endpoint + " FAIL. " + e.getResponseBodyAsString());
		}
		result.put(aucPropertyId, link);
		return result;
	}

	public void createTags() {
		
	}
}