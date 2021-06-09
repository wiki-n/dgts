package crawler.dgts.services;

import java.io.IOException;

import crawler.dgts.dto.WordpressPost;

public class WordpressCLI {
	public void createPost(WordpressPost post) {
		try {
			Runtime.getRuntime().exec("ping www.stackabuse.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
