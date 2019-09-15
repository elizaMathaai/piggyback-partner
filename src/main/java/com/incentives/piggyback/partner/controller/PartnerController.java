package com.incentives.piggyback.partner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.incentives.piggyback.partner.dto.PartnerEntity;
import com.incentives.piggyback.partner.entity.Partner;
import com.incentives.piggyback.partner.service.PartnerService;
import com.incentives.piggyback.partner.util.RestResponse;
import com.incentives.piggyback.partner.util.RestUtils;

@RestController
@RequestMapping("/partner")
public class PartnerController {

	@Autowired
	private PartnerService partnerService;

	@PostMapping
	public ResponseEntity<RestResponse<PartnerEntity>> createPartner(@RequestBody Partner partner) {
		return RestUtils.successResponse(partnerService.createPartner(partner));
	}

	@DeleteMapping
	public ResponseEntity<RestResponse<String>> deletePartner(
			@RequestParam("partnerId") String partnerId) {
		return RestUtils.successResponse(partnerService.deletePartner(partnerId));
	}
	
	@PutMapping
	public ResponseEntity<RestResponse<PartnerEntity>> updatePartner(
			@RequestBody Partner partner) {
		return RestUtils.successResponse(partnerService.updatePartner(partner));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RestResponse<PartnerEntity>> getPartner(
			@PathVariable String partnerId) {
		return RestUtils.successResponse(partnerService.getPartner(partnerId));
	}

	@GetMapping
	public ResponseEntity<RestResponse<Iterable<PartnerEntity>>> getAllPartner() {
		return RestUtils.successResponse(partnerService.getAllPartner());
	}
}