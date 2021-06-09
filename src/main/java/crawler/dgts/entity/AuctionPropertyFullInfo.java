package crawler.dgts.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auction_property_full_info_view")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionPropertyFullInfo {
	@Id
	@Column(name = "AU_PROPERTY_INFO_ID")
	private Integer auctionPropertyInfoId;
	@Column(name = "AUTION_INFO_ID")
	private Integer auctionInfoId;
	@Column(name = "PUBLISH_TIME_1")
	private Long publishTime1;
	@Column(name = "AUC_TIME")
	private Long aucTime;
	@Column(name = "AUC_REG_TIME_START")
	private Long aucRegTimeStart;
	@Column(name = "AUC_REG_TIME_END")
	private Long aucRegTimeEnd;
	@Column(name = "LINK_LOCATION")
	private String linkLocation;
	@Column(name = "PROPERTYNAME")
	private String propertyName;
	@Column(name = "AMOUNT")
	private String propertyAmount;
	@Column(name = "START_PRICE")
	private String propertyStartPrice;
	@Lob
	@Column(name = "DETAIL")
	private String detail;
	@Column(name = "QUALITY")
	private String propertyQuality;
	@Column(name = "DEPOSIT")
	private Integer deposit;
	@Column(name = "DEPOSIT_UNIT")
	private Integer depositUnit;
	@Column(name = "TYPE_ID")
	private Integer propertyTypeId;
	@Column(name = "PLACE")
	private String propertyPlace;
	@Column(name = "FILE_COST")
	private Integer fileCost;
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "AU_PROPERTY_INFO_ID")
//	private List<AutionPropertyTag> tagInfo;
}
