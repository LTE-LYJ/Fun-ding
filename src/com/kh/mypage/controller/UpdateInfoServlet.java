package com.kh.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.mypage.model.service.MypageService;

//import com.kh.mypage.model.vo.Member;


/**
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet("/updateInfo.mp")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("memId");
		String userName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member updateMem = new MypageService().updateMember(new Member(userId, userName, phone, email, address));
		
		if(updateMem != null) {
			request.getSession().setAttribute("msg", "회원 정보를 수정하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
			//response.sendRedirect(request.getContextPath());
			RequestDispatcher view = request.getRequestDispatcher("views/mypage/mypageInfoUpdate.jsp");
			view.forward(request, response);
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
