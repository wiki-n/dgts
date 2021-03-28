package crawler.dgts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUCTION_PROPERTY_SPECIFIED_INFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionPropertySpecifiedInfo {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "AU_PROPERTY_INFO_ID")
	private Integer auPropertyInfoId;
	@Column(name = "NAME")
	private String propertyName;
	@Column(name = "AMOUNT")
	private String propertyAmount;
	@Column(name = "START_PRICE")
	private String propertyStartPrice;
//	@Column(name = "DETAIL")
//	private Clob detail;
	@Lob
	@Column(name = "DETAIL")
	private String detail;
	@Column(name = "QUALITY")
	private String propertyQuality;
	@Column(name = "DEPOSIT")
	private Long deposit;
	@Column(name = "DEPOSIT_UNIT")
	private Integer depositUnit;
	@Column(name = "TYPE_ID")
	private Integer propertyTypeId;
	@Column(name = "TYPE_NAME")
	private String propertyTypeName;
	@Column(name = "AUTION_INFO_ID")
	private Integer auctionInfoId;
	@Column(name = "PLACE")
	private String propertyPlace;
	@Column(name = "FILE_COST")
	private Long fileCost;
	@Column(name = "START_PRICE_STR")
	private String strPropertyStartPrice;
	@Column(name = "DEPOSIT_STR")
	private String strDeposit;
	@Column(name = "FILE_COST_STR")
	private String strFileCost;
	@Column(name = "PROCESS_STATUS")
	private String processStatus;
}
