package com.kh.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.service.MypageService;

/**
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/updatePwd.mp")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = ((Member)request.getSession().getAttribute("loginUser")).getMemId();
		
		String memPwd = request.getParameter("memPwd");
		String changePwd = request.getParameter("changePwd");
		
		Member updateMem = new MypageService().updatePwd(memId, memPwd, changePwd);
		
		RequestDispatcher view  = request.getRequestDispatcher("views/mypage/mypageInfoUpdate.jsp");
		
		if(updateMem != null) {
			request.setAttribute("sTag", "Y");
			request.setAttribute("msg", "비밀번호가 변경되었습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
		}else {
			
			request.setAttribute("msg", "비밀번호 변경 실패");
		}
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
