package crawler.dgts.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
	@Value("classpath:templates/postContent.html")
	Resource resourceFile;
	@Autowired
	private WordPressAPIService wpAPIService;
	//create wordpress post. title, content, tags, category
	public Map<Integer,WordpressPost> createPostData(String category, Integer max){
		Map<Integer,WordpressPost> posts = new HashMap<>();
		List<AuctionPropertyFullInfoDto> unProcessedProperties = new ArrayList<>();
		unProcessedProperties = auctionPropertyInfoService.getUnprocessAuctionProperty(max);
		if(CollectionUtils.isEmpty(unProcessedProperties)) {
			return posts;
		}
		String content = "";
		try {
			content = new BufferedReader(
				      new InputStreamReader(resourceFile.getInputStream(), StandardCharsets.UTF_8))
				        .lines()
				        .collect(Collectors.joining("\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(CollectionUtils.isEmpty(unProcessedProperties)) {
			return posts;
		}
		
		for (AuctionPropertyFullInfoDto property : unProcessedProperties) {
			WordpressPost post = new WordpressPost();
			post.setTittle(property.getPropertyName());
			post.setContent(content.replace("${propertyName}", property.getPropertyName())
					.replace("${startPrice}", property.getPropertyStartPrice())
					.replace("${deposit}", property.toString()).replace("${auctionTime}", property.toString())
					.replace("${regTime}", property.toString()));
			post.setExcerpt(""); //TODO
			// create, get tags, categoried first
//			post.setTags(unProcessedProperties.get(0).getTags());
			posts.put(property.getAuctionPropertyInfoId(), post);
		};

		return posts;
		}
	
	public Map<Integer,String> sendPost(Map<Integer,WordpressPost> posts) {
		Map<Integer,String> resultLinkMap = new HashMap<>();
		// multi thread!!
//		Collectors.toList(posts.values).(post ->{
//			wpAPIService.createPost(post);
//		});
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<Callable<Map<Integer,String>>> callableTasks = new ArrayList<>();
		posts.forEach((auctionPropertyInfoId,post)->{
//			resultLinkMap.put(auctionPropertyInfoId, null);
			Callable<Map<Integer,String>> callableTask = () ->{
				return wpAPIService.createPost(auctionPropertyInfoId, post);
			};
			callableTasks.add(callableTask);
		});
		try {
			List<Future<Map<Integer,String>>> responses = executor.invokeAll(callableTasks);
			responses.forEach(response ->{
				try {
					resultLinkMap.putAll(response.get());
				} catch (InterruptedException e) {
					log.info("ProviderService sendPost error "+ e);
					Thread.currentThread().interrupt();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					log.info("ProviderService sendPost error "+ e);
				}
			});
		} catch (InterruptedException e) {
			log.info("ProviderService sendPost error "+ e);
			Thread.currentThread().interrupt();
		}
		return resultLinkMap;
	}
}
