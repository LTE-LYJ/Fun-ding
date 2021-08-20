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
		
		String memName = request.getParameter("memName");
		System.out.println(memName);
		
		ArrayList<Member> list = new MemberService().selectList();	
		
		ArrayList<Member> newList = new ArrayList();
		
		JSONArray jArr = new JSONArray(); 
		
		JSONObject jsonUser = null;
		
		for(Member member : list) { // 관리자 정보 제외
			
			if(member.getMemNo() != 100) {
				newList.add(member);
			}
		}
		
		
		for(Member mem : newList) {
			System.out.println(mem.getMemName().contains(memName));
			
			if(mem.getMemName().contains(memName)) {
				jsonUser = new JSONObject();
				
				jsonUser.put("no", mem.getMemNo());
				jsonUser.put("name", mem.getMemName());
				jsonUser.put("id", mem.getMemId());
				jsonUser.put("email", mem.getEmail());
			
				jArr.add(jsonUser);
			}
		}
		
		System.out.println(jArr.size());
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
