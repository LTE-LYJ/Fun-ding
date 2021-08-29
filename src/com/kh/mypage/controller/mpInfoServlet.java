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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.attachment.model.vo.ProfileAttachment;
//import com.kh.mypage.model.vo.Attachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
//import com.kh.mypage.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/info.mp")
public class mpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("views/mypage/mypageInfo.jsp").forward(request, response);
		
		
		request.setCharacterEncoding("UTF-8");
		
			
		
			Member loginUser = (Member)request.getSession().getAttribute("loginUser");
			
			String userId = loginUser.getMemId();
			
			Member member = new MemberService().selectMember(userId);
			
			System.out.println("member : " + member);
			
			
			
			RequestDispatcher view = null;
			if(member != null) {
				request.setAttribute("loginUser", loginUser);
				view = request.getRequestDispatcher("views/mypage/mypageInfo.jsp");
			}else {
				
				request.setAttribute("msg", "조회에 실패하였습니다.");
				view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
