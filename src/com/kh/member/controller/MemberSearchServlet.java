package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberPageInfo;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/searchMember.bo")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mem = request.getParameter("mem");
		String selValue = request.getParameter("selValue");
		
		ArrayList<Member> list = new MemberService().searchList();	
		
		JSONArray jArr = new JSONArray(); 
		
		JSONObject jsonUser = null;
		

		if(selValue.equals("회원번호")) {
			System.out.println("회원번호로 검색");
			
			for(Member member : list) {
				
				if(member.getMemNo() == Integer.parseInt(mem)) {
					jsonUser = new JSONObject();
					
					jsonUser.put("no", member.getMemNo());
					jsonUser.put("name", member.getMemName());
					jsonUser.put("id", member.getMemId());
					jsonUser.put("email", member.getEmail());
				
					jArr.add(jsonUser);
				}
			}
			
		} else if (selValue.equals("회원이름")) {
			System.out.println("회원이름으로 검색");
			
			for(Member member : list) {
				
				if(member.getMemName().contains(mem)) {
					jsonUser = new JSONObject();
					
					jsonUser.put("no", member.getMemNo());
					jsonUser.put("name", member.getMemName());
					jsonUser.put("id", member.getMemId());
					jsonUser.put("email", member.getEmail());
				
					jArr.add(jsonUser);
				}
			}
			
			
		} else if (selValue.equals("아이디")) {
			System.out.println("아이디로 검색");
			
			for(Member member : list) {
				
				if(member.getMemId().contains(mem)) {
					jsonUser = new JSONObject();
					
					jsonUser.put("no", member.getMemNo());
					jsonUser.put("name", member.getMemName());
					jsonUser.put("id", member.getMemId());
					jsonUser.put("email", member.getEmail());
				
					jArr.add(jsonUser);
				}
			}
			
		}
		
		
	
		
		
		

		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 out.print(jArr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
