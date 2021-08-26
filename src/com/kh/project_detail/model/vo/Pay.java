package com.kh.project_detail.model.vo;

import lombok.Data;

@Data
public class Pay {
	//결제 및 결제수단 정보
	
	private int payNo; //결제번호
	private int memNo; //회원번호
	private int prjNo; //프로젝트번호
	private int price; //결제금액
	private int fdNo; //후원번호
	private String payDate; //카드유효기간
	private int payMNo; //결제수단번호
	private long cardNo; //카드번호
	private String cardPwd; //결제 비밀번호
	private String birth; //생년월일
	private String bank; //은행명
	
	
	public Pay() {
		// TODO Auto-generated constructor stub
	}
	public Pay(int memNo, int prjNo, int price, int fdNo) {
		super();
		this.memNo = memNo;
		this.prjNo = prjNo;
		this.price = price;
		this.fdNo = fdNo;
	}
}
