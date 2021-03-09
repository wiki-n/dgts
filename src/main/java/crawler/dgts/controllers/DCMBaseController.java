package crawler.dgts.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(DCMBaseController.BASE_PATH)
@Slf4j
public class DCMBaseController extends BaseWebService {

	public static final String BASE_PATH = "/api/i/v1";

	public static final String BASE_PATH_INTERNAL = "/api/i/v1";

}
