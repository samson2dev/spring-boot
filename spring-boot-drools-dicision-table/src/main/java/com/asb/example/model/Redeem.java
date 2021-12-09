package com.asb.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Redeem {
	
	private String code;
	private int basePoint;
	private int limitUnit;
	private String limitType;
	
	public Redeem(String code,int basePoint, int limitUnit,String limitType) {
		this.code = code;
		this.basePoint = basePoint;
		this.limitUnit = limitUnit;
		this.limitType =limitType;
	}
}
