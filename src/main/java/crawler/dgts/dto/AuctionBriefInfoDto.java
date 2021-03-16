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
public class AuctionBriefInfoDto {
	private Integer id;
	private String propertyName;
	private Long publishTime1;
	private Long aucTime;
	private Long aucRegTimeStart;
	private Long aucRegTimeEnd;
	private String titleName;
	private String subPropertyName;
}
