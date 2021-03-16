package crawler.dgts.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import crawler.dgts.dto.DCMResponse;
import crawler.dgts.utils.AppConstant;
import crawler.dgts.utils.AppConstant.ERROR_CODE;
import lombok.extern.slf4j.Slf4j;;

@Slf4j
public class BaseWebService {


	@Value("${crawler.service.apiAuthKey}")
	private String crawlerServiceApiAuthkey;

	@Value("${crawler.service.publicKey}")
	private String crawlerServicePublicKey;

	public ResponseEntity<Object> generateOK(Object data) {
		return ResponseEntity.ok(data);
	}

	public ResponseEntity<Object> generateOK() {
		return ResponseEntity.status(HttpStatus.OK).body(new DCMResponse(AppConstant.ERROR_CODE.OK));
	}

	public ResponseEntity<Object> generateNOK(int httpCode, int errorCode) {
		return ResponseEntity.status(httpCode).body(new DCMResponse(errorCode));
	}

	public ResponseEntity<Object> generateNOK(int httpCode, Object data) {
		return ResponseEntity.status(httpCode).body(data);
	}

	protected int validateToken(String token) {
		if (token == null || token.trim().isEmpty() || !token.equals(crawlerServiceApiAuthkey))
			return ERROR_CODE.INVALID_TOKEN;

		return ERROR_CODE.OK;
	}

	protected int validatePublicToken(String token) {
		if (token == null || token.trim().isEmpty() || !token.equals(crawlerServicePublicKey))
			return ERROR_CODE.INVALID_TOKEN;

		return ERROR_CODE.OK;
	}

}
