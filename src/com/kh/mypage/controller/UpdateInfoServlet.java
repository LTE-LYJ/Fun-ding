package com.kh.mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.mypage.model.service.MypageService;
import com.oreilly.servlet.MultipartRequest;

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
		
		request.setCharacterEncoding("UTF-8");
		/*
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		//String memId = loginUser.getMemId();
		
		String memId = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member updateMem = new MypageService().updateMember(new Member(memId, memName, phone, email, address));
		
		if(updateMem != null) {
			request.getSession().setAttribute("msg", "회원 정보를 수정하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
			response.sendRedirect(request.getContextPath());
			//RequestDispatcher view = request.getRequestDispatcher("views/mypage/mypageInfoUpdate.jsp");
			//view.forward(request, response);
		}else {
			
			request.setAttribute("msg", "회원 정보 수정에 실패했습니다");	
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}*/
		
			
		/*///////////
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
	
		String memId = loginUser.getMemId();
		
		Member member = new MemberService().selectMember(memId);
		
		System.out.println("member : " + member);
		
		
		//ProfileAttachment at = null;
		
		
		
		Member result = new MypageService().updateMember(member);
		
		RequestDispatcher view = null;
		
		if(member != null) {
			request.setAttribute("loginUser", loginUser);
			view = request.getRequestDispatcher("views/mypage/mypageInfoUpdate.jsp");
		}else {
			
			request.setAttribute("msg", "조회에 실패하였습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		
		view.forward(request, response);
		*/
		
		
		
		
		///
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		String memId = loginUser.getMemId();
		//int memNo = loginUser.getMemNo();
		
		//
		Member member = new MemberService().selectMember(memId);
		System.out.println("member : " + member);
		
		int memNo = new MemberService().selectMemNo(memId);
		
		
		ProfileAttachment at = new MypageService().selectAttachment(memNo);
		
		int result = new MemberService().insertAttachment(at, memNo);
		
		if(result > 0) {
			request.setAttribute("loginUser", loginUser);
			request.setAttribute("at", at);
			request.getRequestDispatcher("views/mypage/mypageInfoUpdate.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원정보 변경에 실패했습니다.");
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
