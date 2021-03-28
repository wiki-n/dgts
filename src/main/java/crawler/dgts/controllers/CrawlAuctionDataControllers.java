package crawler.dgts.controllers;

import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import crawler.dgts.dto.AuctionBriefInfoDto;
import crawler.dgts.dto.AuctionSearchInput;
import crawler.dgts.dto.DCMResponse;
import crawler.dgts.services.CrawlAuctionDataService;
import crawler.dgts.utils.AppConstant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestScope
@RequestMapping(DCMBaseController.BASE_PATH_INTERNAL + "/dgts")
@Slf4j
public class CrawlAuctionDataControllers extends DCMBaseController {

	@Autowired
	private CrawlAuctionDataService crawlAuctionDataService;

	@RequestMapping(value = "/district", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get All Districts", tags = "Province/District", nickname = "/cloneDistrictDgts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DCMResponse.class),
			@ApiResponse(code = 400, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 404, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = DCMResponse.class) })
	public ResponseEntity<Object> crawlAllDistricts() {
		DCMResponse response = crawlAuctionDataService.cloneAllDistrictsDtgs();
		if (response.getCode() == AppConstant.ERROR_CODE.OK) {
			return generateOK();
		} else {
			return generateNOK(HttpStatus.SC_BAD_REQUEST, AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/autionBrief", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Auction Notice Brief Info", tags = "Auction", nickname = "/auctionBrief")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DCMResponse.class),
			@ApiResponse(code = 400, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 404, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = DCMResponse.class) })
	public ResponseEntity<Object> crawlAuctionBriefInfo(@RequestBody AuctionSearchInput searchInput) {
		List<AuctionBriefInfoDto> aucBriefInfos = crawlAuctionDataService.getAuctionBrief(searchInput);
		if (aucBriefInfos != null) {
			return generateOK(aucBriefInfos);
		} else {
			return generateNOK(HttpStatus.SC_BAD_REQUEST, AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/autionFullInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Auction Property Full Info", tags = "Auction", nickname = "/auctionFullInfo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DCMResponse.class),
			@ApiResponse(code = 400, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 404, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = DCMResponse.class) })
	public ResponseEntity<Object> crawlAuctionFullInfo(@RequestBody AuctionSearchInput searchInput) {
		DCMResponse response = crawlAuctionDataService.getAuctionFull(searchInput);
		if (response.getCode() == AppConstant.ERROR_CODE.OK) {
			return generateOK();
		} else {
			return generateNOK(HttpStatus.SC_BAD_REQUEST, AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/cloneAuctionDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Trigger Clone Auction Property Details Info", tags = "Auction", nickname = "/cloneAuctionDetails")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DCMResponse.class),
			@ApiResponse(code = 400, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 404, message = "Internal Server Error", response = DCMResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = DCMResponse.class) })
	public ResponseEntity<Object> crawlAuctionDetailInfo(@Param("totalRecords") Integer totalRecords,
			@Param("processNumber") Integer processNumber) {
		DCMResponse response = crawlAuctionDataService.cloneAuctionDetails(totalRecords, processNumber);
		if (response.getCode() == AppConstant.ERROR_CODE.OK) {
			return generateOK();
		} else {
			return generateNOK(HttpStatus.SC_BAD_REQUEST, AppConstant.ERROR_CODE.INTERNAL_SERVER_ERROR);
		}
	}
}
