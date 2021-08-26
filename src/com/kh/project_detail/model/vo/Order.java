package com.kh.project_detail.model.vo;

import lombok.Data;

@Data
public class Order {
	//배송정보
	
	private int orderNo; //배송정보번호
	private String memName; //구매자이름
	private String phone; //배송연락처
	private String receiverName; //받는사람이름
	private String shippingAddr; //배송지
	private int fdNo; //후원번호


	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(String memName, String phone, String receiverName, String shippingAddr) {
		super();
		this.memName = memName;
		this.phone = phone;
		this.receiverName = receiverName;
		this.shippingAddr = shippingAddr;
	}
	
}
