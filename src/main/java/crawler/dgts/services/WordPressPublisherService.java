package crawler.dgts.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import crawler.dgts.dto.WordpressPost;
import crawler.dgts.services.common.BaseClientService;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class WordPressPublisherService extends BaseClientService {
	@Autowired
	private ProviderService providerService;
	@Autowired
	private AuctionPropertySpecifiedService auctionPropertySpecifiedService;
	public void wordPressPublisher(Integer max) {
		Map<Integer, String> processResult = providerService.sendPost(providerService.createPostData(null, max));
		if(CollectionUtils.isEmpty(processResult)) {
			return;
		}
		processResult.forEach((aucPropertyId, postLink)->{
			//update result
			auctionPropertySpecifiedService.updateProcessStatus(aucPropertyId, postLink);
		});
	}
}
