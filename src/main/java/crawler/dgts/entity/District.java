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
@Table(name = "DISTRICT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class District {
	@Id
	@Column(name = "CODE")
	private int code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PROVINCE_CODE")
	private int provinceCode;
}
