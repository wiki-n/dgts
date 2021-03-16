package crawler.dgts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity
public class AuctionBriefInfo {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NAME")
	private String propertyName;
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
	@Column(name = "PROCESS_STATUS")
	private String processStatus;
}
