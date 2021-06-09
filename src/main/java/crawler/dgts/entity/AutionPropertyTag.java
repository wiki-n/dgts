package crawler.dgts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROPERTY_TAGS_VIEW")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutionPropertyTag {
	@Id
	@JsonIgnore
	@Column(name = "UUID")
    private Long id;

	@Column(name = "AU_PROPERTY_INFO_ID")
	private Integer auctionPropertyInfoId;
	
	@Column(name = "INFO_TAG")
	private String tag;
}
