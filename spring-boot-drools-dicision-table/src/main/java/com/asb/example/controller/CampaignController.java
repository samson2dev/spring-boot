package com.asb.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asb.example.model.OrderRequest;
import com.asb.example.service.CampaignService;

import io.swagger.annotations.Api;

@Api(tags = "Campaign Test")
@RestController
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@PostMapping("/doAward")
	public ResponseEntity<OrderRequest> doAward(@RequestBody OrderRequest orderRequest) {
		OrderRequest req = campaignService.doAward(orderRequest);
		return new ResponseEntity<>(req, HttpStatus.OK);
	}
	
	@PostMapping("/doRedeem")
	public ResponseEntity<OrderRequest> doRedeem(@RequestBody OrderRequest orderRequest) {
		OrderRequest req = campaignService.doRedeem(orderRequest);
		return new ResponseEntity<>(req, HttpStatus.OK);
	}
}