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
public class AdvancedAuctionSearchInput extends AuctionSearchInput{
	private String actualProvinceId;
	private String actualDistrictId;
	private String startApplyDate; //dd/mm/yyyy       06%2F03%2F2021
	private String endApplyDate; //dd/mm/yyyy       06%2F03%2F2021
}
