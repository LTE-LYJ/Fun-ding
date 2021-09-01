package com.kh.mypage.controller;

import com.kh.member.model.vo.Member;
import com.kh.mypage.model.service.MypageService;
import com.kh.mypage.model.vo.Board;
import com.kh.mypage.model.vo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BoardMainListServlet
 */
@WebServlet("/boardMainList.mp")
public class BoardMainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMainListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Member.loginMember(request).getMemNo();
		
		PageInfo pageInfo = PageInfo.fromRequest(request, new MypageService().getMainListCount(memNo));
		List<Board> list = new MypageService().selectMainList(memNo, pageInfo);

		request.setAttribute("list", list);
		request.setAttribute("pi", pageInfo);

		request.getRequestDispatcher("views/mypage/mypageBoardMainList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
