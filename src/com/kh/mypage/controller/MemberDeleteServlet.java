package com.kh.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mypage.model.service.MypageService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/memberDelete.mp")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("id");
		String memPwd = request.getParameter("passwd");

		int result = new MypageService().deleteMember(memId, memPwd);

		if(result > 0) {
			HttpSession session = request.getSession();
			
			session.removeAttribute("loginUser");
			session.setAttribute("msg", "회원 탈퇴가 완료되었습니다");
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "회원 탈퇴에 실패했습니다");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
