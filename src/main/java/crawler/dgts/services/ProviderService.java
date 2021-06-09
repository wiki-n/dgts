package crawler.dgts.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import crawler.dgts.dto.AuctionPropertyFullInfoDto;
import crawler.dgts.dto.WordpressPost;
import crawler.dgts.services.common.BaseClientService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProviderService extends BaseClientService {
	@Autowired
	private AuctionPropertyInfoService auctionPropertyInfoService;
	@Value("classpath:data/templates/postContent.html")
	Resource resourceFile;
	@Autowired
	private WordPressAPIService wpAPIService;
	//create wordpress post. title, content, tags, category
	public List<WordpressPost> createPostData(String category, Integer max){
		List<WordpressPost> posts = new ArrayList<>();
		List<AuctionPropertyFullInfoDto> unProcessedProperties = new ArrayList<>();
		unProcessedProperties = auctionPropertyInfoService.getUnprocessAuctionProperty(max);
		if(CollectionUtils.isEmpty(unProcessedProperties)) {
			return posts;
		}
		String content = null;
		try {
			content = new BufferedReader(
				      new InputStreamReader(resourceFile.getInputStream(), StandardCharsets.UTF_8))
				        .lines()
				        .collect(Collectors.joining("\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		content.replace("${propertyName}", unProcessedProperties.get(0).getPropertyName())
				.replace("${startPrice}", unProcessedProperties.get(0).getPropertyStartPrice())
				.replace("${deposit}", (unProcessedProperties.get(0).getDeposit()).toString())
				.replace("${auctionTime}", unProcessedProperties.get(0).getAucTime().toString())
				.replace("${regTime}", unProcessedProperties.get(0).getAucRegTimeStart().toString());
		WordpressPost post = new WordpressPost();
		post.setTittle(unProcessedProperties.get(0).getPropertyName());
		post.setContent(content);
		// create, get tags, categoried first
//		post.setTags(unProcessedProperties.get(0).getTags());
		posts.add(post);
		return posts;
		}
	
	public void sendPost(List<WordpressPost> posts) {
		posts.forEach(post ->{
			wpAPIService.createPost(post);
		});
	}
}
