package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberPageInfo;

/**
 * Servlet implementation class MemberListFormServlet
 */
@WebServlet("/memberList.bo")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 만들기!
		int listCount;
		int currentPage;
		int startPage;
		int endPage;
		int maxPage;
		
		int pageLimit;
		int boardLimit;
		
		listCount =  new MemberService().getListCount(); //관리자를 제외한 전체 회원수
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit +1 ;
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		System.out.println("currentPage : " + currentPage);
		//System.out.println(maxPage);
		
		MemberPageInfo pi = new MemberPageInfo(listCount, currentPage, startPage, endPage,  maxPage, pageLimit, boardLimit);
				
		// 전체 회원 조회하는 페이지(sql문에서 관리자 회원번호는 제외할 것)
		ArrayList<Member> list = new MemberService().selectList(pi);	
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/member/memberList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
