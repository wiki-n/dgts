package crawler.dgts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {
	private int id; //district Code
	private String name; //district name
	private String code; 
	private String catType;
	private String level;
	private int parentId; //province code
	private String createdBy;
	private String modifiedBy;
	private Long createdDate;
	private Long modifyDate;
	private String status;
	private String des;
}
