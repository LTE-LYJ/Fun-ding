package com.kh.member.model.vo;
//테스트
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Member {
	//회원정보
	//push 테스트
	//push테스트22222-주연
	private int memNo; //회원번호
	private String memId; //아이디
	private String memPwd; //비밀번호
	private String memName; //이름
	private String phone; //연락처
	private String email; //이메일
	private String address; //주소
	private Date enrollDate; //회원가입일
	private String status; //상태값(Y/N)
	private int coin; //보유코인
	private int prjNo; //프로젝트 번호	
	
	
	
	//mypage
	public Member() {}

	public Member(String memId, String memName, String phone, String email, String address) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public static Member loginMember(HttpServletRequest request) {
		return (Member)request.getSession().getAttribute("loginUser");
	}
	
}
