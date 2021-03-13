package crawler.dgts.services.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import crawler.configs.TimeoutConfig;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BaseClientService extends BaseService {

	public static final String CONTENT_TYPE = "Content-Type";
	public static final String AUTHORIZATION = "Authorization";
	public static final String X_API_KEY = "X-API-KEY";

	@Value("${crawler.service.apiAuthKey}")
	protected String crawlerServiceXApiKey;

	@Autowired
	protected TimeoutConfig timeout;

	protected RestTemplate getRestTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
	}

	protected HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		return headers;
	}

	protected ClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(timeout.getConnectTimeout());
		clientHttpRequestFactory.setConnectionRequestTimeout(timeout.getRequestTimeout());
		clientHttpRequestFactory.setReadTimeout(timeout.getReadTimeout());
		return clientHttpRequestFactory;
	}
}
