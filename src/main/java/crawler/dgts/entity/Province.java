package crawler.dgts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PROVINCE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Province {
	@Id
	@Column(name="CODE")
	private int code;
	
	@Column(name="NAME")
	private String name;
}
