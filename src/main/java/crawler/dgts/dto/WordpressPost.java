package crawler.dgts.dto;

import java.util.List;

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
public class WordpressPost {
	private String tittle;
	private String content;
	private String excerpt;
	private List<String> tags;
}
