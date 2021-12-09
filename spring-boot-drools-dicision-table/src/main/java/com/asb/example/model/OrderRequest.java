package com.asb.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
	
	/* customer name */
	private String name;
	/* customer birthdate */
	private String birthDate;
	/* customer card type */
	private String cardType;
	
	/* input date string */
	private String yyyyMMdd;
	/* input txn amount */
	private int amount;
	/* input merchant name */
	private String merchantName;
	
	/* find by system */
	private int todayAwardCnt;
	/* find by system */	
	private int totalAwardCnt;
	
	/* response award */
	private List<Award> awardList = new ArrayList<Award>();

	private List<Redeem> redeemList = new ArrayList<Redeem>();
	
	private String redeemGiftType;
	
	public void addAward(String code, int cnt) {
		awardList.add(new Award(code,cnt));
	}
	public void mulAward(int num) {
		for (Award award:awardList) {
			award.setCnt(award.getCnt()*num);
		}
	}
	public void addRedeem(String code, int basePoint, int limitUnit, String limitType) {
		redeemList.add(new Redeem(code,basePoint,limitUnit,limitType));
	}
	public int findMonth() {
		int ret = 0;
		
		if (yyyyMMdd!=null && yyyyMMdd.length()>=8) {
			ret = Integer.parseInt(yyyyMMdd.substring(4, 6));
		}
		return ret;
	}
	public int findDateOfMonth() {
		int ret = 0;
		
		if (yyyyMMdd!=null && yyyyMMdd.length()>=8) {
			ret = Integer.parseInt(yyyyMMdd.substring(6, 8));
		}
		return ret;
	}
	
	public int findDayOfWeek() {
		int ret = 0;
		if (yyyyMMdd!=null && yyyyMMdd.length()>=8) {
			int year = Integer.parseInt(yyyyMMdd.substring(0, 4));
			int month = Integer.parseInt(yyyyMMdd.substring(4, 6));
			int day = Integer.parseInt(yyyyMMdd.substring(6, 8));
			LocalDate date = LocalDate.of(year, month, day);
			ret = date.getDayOfWeek().getValue();
		}
		return ret;
	}
}