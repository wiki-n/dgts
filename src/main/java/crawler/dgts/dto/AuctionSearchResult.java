package crawler.dgts.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuctionSearchResult {
	private List<Object> items;
	private Integer rowCount;
	private Integer numberPerPage;
	private Integer pageNumber;
	private List<Integer> pageList;
	private Integer pageCount;
}
