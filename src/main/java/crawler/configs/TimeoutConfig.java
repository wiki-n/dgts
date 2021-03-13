package crawler.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Configuration
@ConfigurationProperties(prefix = "rest")
@Getter
@Setter
public class TimeoutConfig {

	private int connectTimeout;
	private int requestTimeout;
	private int readTimeout;

}
