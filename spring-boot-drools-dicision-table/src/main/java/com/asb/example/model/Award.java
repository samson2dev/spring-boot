package com.asb.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Award {
	
	private String code;
	private int cnt;
	
	public Award(String code,int cnt) {
		this.code = code;
		this.cnt = cnt;
	}
}
