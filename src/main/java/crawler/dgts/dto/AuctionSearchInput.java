package crawler.dgts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuctionSearchInput {
	private String endDate;
	private String endPublishDate; //dd/mm/yyyy       06%2F03%2F2021
	private String numberPerPage;//       10
	private String p; //       1
	private String provinceId; //       100001
	private String searchSimple;
	private String selectedOrganizationId;
	private String startDate;
	private String startPublishDate;
}
