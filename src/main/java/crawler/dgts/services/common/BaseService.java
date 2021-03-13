package crawler.dgts.services.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BaseService {
	
	@Autowired
	protected ObjectMapper objectMapper;

}
