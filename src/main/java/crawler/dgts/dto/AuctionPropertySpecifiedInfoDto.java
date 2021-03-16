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
public class AuctionPropertySpecifiedInfoDto {
	private Integer auPropertyInfoId;
	private String propertyName;
	private String propertyAmount;
	private String propertyStartPrice;
	private String detail;
	private String propertyQuality;
	private Integer deposit;
	private Integer depositUnit;
	private Integer propertyTypeId;
	private String propertyTypeName;
	private Integer auctionInfoId;
	private String propertyPlace;
	private Integer fileCost;
	private String strPropertyStartPrice;
	private String strDeposit;
	private String strFileCost;
}
