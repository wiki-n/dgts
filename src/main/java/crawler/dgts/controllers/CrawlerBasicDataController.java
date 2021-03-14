package crawler.dgts.controllers;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import crawler.dgts.dto.DCMResponse;
import crawler.dgts.dto.ProvinceDto;
import crawler.dgts.services.CrawlerBasicDataService;
import crawler.dgts.utils.AppConstant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestScope
@RequestMapping(DCMBaseController.BASE_PATH_INTERNAL + "/basicData")
@Slf4j
public class CrawlerBasicDataController extends DCMBaseController {

	@Autowired
	private CrawlerBasicDataService crawlerBasicDataService;
	@RequestMapping(value = "/district", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get All Districts", tags = "Province/District", nickname = "/cloneDistrictDgts")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = DCMResponse.class),
            @ApiResponse(code = 400, message = "Internal Server Error", response = DCMResponse.class),
            @ApiResponse(code = 404, message = "Internal Server Error", response = DCMResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = DCMResponse.class)})
	public ResponseEntity<Object> crawlAllDistricts() {
		DCMResponse response = crawlerBasicDataService.cloneAllDistrictsDtgs();
		if(response.getCode() == AppConstant.ERROR_CODE.OK) {
			return generateOK();
		} else {
			return generateNOK(HttpStatus.SC_BAD_REQUEST, AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}		
	}
}
