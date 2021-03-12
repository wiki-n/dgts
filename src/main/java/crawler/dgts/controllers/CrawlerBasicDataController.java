package crawler.dgts.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import crawler.dgts.dto.DCMResponse;
import crawler.dgts.dto.ProvinceDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestScope
@RequestMapping(DCMBaseController.BASE_PATH_INTERNAL + "/basicData")
@Slf4j
public class CrawlerBasicDataController extends DCMBaseController {

	@RequestMapping(value = "/province", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get All Provinces", tags = "Province", nickname = "/province POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ProvinceDto[].class),
            @ApiResponse(code = 400, message = "Internal Server Error", response = DCMResponse.class),
            @ApiResponse(code = 404, message = "Internal Server Error", response = DCMResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = DCMResponse.class)})
	public ResponseEntity<Object> crawlAllProvinces() {
		return null;
		
	}
}
