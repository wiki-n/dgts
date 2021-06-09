package crawler.dgts.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
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
		headers.set(CONTENT_TYPE, "application/json");
		headers.set(AUTHORIZATION, wpPass);
		;
		return headers;
	}

	// password for hoangpd application: MFiT wnKl YTM6 bNAN iuHC VJwP
	/*
	 * curl -L -X POST
	 * 'http://localhost:8000/wp-json/wp/v2/posts?title=Test%20title&content=test%
	 * 20content&tags=1' -H 'Authorization: Basic
	 * aG9hbmdfZGV2Ok1GaVQgd25LbCBZVE02IGJOQU4gaXVIQyBWSndQ'
	 */
	public void createPost(WordpressPost post) {
		RestTemplate restTemplate = getRestTemplate();
		HttpEntity<WordpressPost> request = new HttpEntity<>(post, getHeaders());
		UriComponentsBuilder builder = null;
		builder = UriComponentsBuilder.fromHttpUrl(wpServiceUrl).path(pathPost);

		String endpoint = builder.toUriString();
		log.info("With Endpoint {} ", endpoint);
		try {
			restTemplate.exchange(wpServiceUrl, HttpMethod.POST, request, WordpressPost.class);
		} catch (HttpClientErrorException e) {
			log.error("Call API " + endpoint + " FAIL. " + e.getResponseBodyAsString());
			throw new RuntimeException("Call API " + endpoint + " FAIL. " + e.getResponseBodyAsString());
		}
	}

	public void createTags() {
		
	}
}