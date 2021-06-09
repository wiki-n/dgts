package crawl.dgts;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import crawler.dgts.services.ProviderService;
@ContextConfiguration(classes = App.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProviderServiceTest {

	@Autowired
	private ProviderService providerService;
	
	@Test
	public void testWordPressPublishMethod() {
		System.out.print("teste----------------");
		providerService.sendPost(providerService.createPostData(null, 2));
	}
}
