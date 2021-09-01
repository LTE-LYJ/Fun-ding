package com.kh.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.mypage.model.service.MypageService;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.mypage.model.vo.Project_report;

/**
 * Servlet implementation class BoardReportListServlet
 */
@WebServlet("/boardReportList.mp")
public class BoardReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memNo = Member.loginMember(request).getMemNo();

		PageInfo pageInfo = PageInfo.fromRequest(request, new MypageService().getReportListCount(memNo));
		
		List<Project_report> list = new MypageService().selectReportList(memNo, pageInfo);

		request.setAttribute("list", list);
		request.setAttribute("pi", pageInfo);
		request.getRequestDispatcher("views/mypage/mypageBoardReportList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
