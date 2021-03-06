package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailViewServlet
 */
@WebServlet("/views/notice/noticeDetailView")
public class NoticeDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		HttpSession session = request.getSession();
		int memNo = 0;
		if(request.getSession().getAttribute("loginUser") != null) {
			
			memNo = ((Member)session.getAttribute("loginUser")).getMemNo();
			}
		NoticeService service = new NoticeService();
		int result = service.updateCount(noticeNo);
		Notice notice = service.getNotice(noticeNo);
		Notice prevNo = service.getPrevNotice(noticeNo);
		Notice nextNo = service.getNextNotice(noticeNo);
		request.setAttribute("n", notice);
		request.setAttribute("prev", prevNo);
		request.setAttribute("next", nextNo);
		request.setAttribute("memNo", memNo);
		
		request.getRequestDispatcher("/views/notice/noticeDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
