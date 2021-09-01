package com.kh.mypage.controller;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        
        String memId = loginUser.getMemId();

        Member member = new MemberService().selectMember(memId);
        
		String profileImage = null;
		
		ProfileAttachment at = new MemberService().memberProfile(memId);
		if (at != null) {
			profileImage = at.getChangeName();
		}

        RequestDispatcher view;
        
        if (member != null) {
            request.setAttribute("loginUser", loginUser);
            request.setAttribute("profileImage", profileImage);
            view = request.getRequestDispatcher("views/mypage/mypageInfoUpdate.jsp");
        } else {
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
