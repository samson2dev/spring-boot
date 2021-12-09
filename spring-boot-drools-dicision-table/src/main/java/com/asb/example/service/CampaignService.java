package com.asb.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asb.example.model.OrderRequest;

@Service
public class CampaignService {

	@Autowired
	private KieContainer kieContainer;

	public OrderRequest doAward(OrderRequest orderRequest) {
		findTodayAward(orderRequest);
		findTotalAward(orderRequest);
		
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.insert(orderRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return orderRequest;
	}
	
	public OrderRequest doRedeem(OrderRequest orderRequest) {
				
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.insert(orderRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return orderRequest;
	}
	
	private void findTodayAward(OrderRequest orderRequest) {
		//TODO: find  customer today's award
	}
	
	private void findTotalAward(OrderRequest orderRequest) {
		//TODO: find  customer total award 
	}
}