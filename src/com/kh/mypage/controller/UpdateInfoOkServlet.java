package com.kh.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mypage.model.service.MypageService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class UpdateInfoOkServlet
 */
@WebServlet("/updateInfoOk.mp")
public class UpdateInfoOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member updateMem = new MypageService().updateMember(new Member(memId, memName, phone, email, address));
		
		if(updateMem != null) {
			request.getSession().setAttribute("msg", "성공적으로 회원 정보를 수정하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem); //최신 정보
			response.sendRedirect(request.getContextPath());
		}else {
			
			request.setAttribute("msg", "회원 정보 수정에 실패했습니다");
			
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
