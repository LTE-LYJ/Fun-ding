package com.kh.project_detail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.ProjectAsk;

/**
 * Servlet implementation class prjAskInsertServlet
 */
@WebServlet("/insert.ask")
public class prjAskInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prjAskInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginUser = String.valueOf(((Member)request.getSession().getAttribute("loginUser")).getMemNo());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));

		ProjectAsk a = new ProjectAsk();
		
		a.setMemId(loginUser);
		a.setPrjNo(num);
		a.setPrjAskTitle(title);
		a.setPrjAskContent(content.replaceAll("\n","<br>"));
		
		int result = new PrjDeService().insertAsk(a);
		
		RequestDispatcher view = request.getRequestDispatcher("views/project_detail/projectDetailAskNewPop.jsp");
		if(result>0) {
			request.setAttribute("sTag", "Y" );
			request.getSession().setAttribute("msg", "문의가 성공적으로 등록되었습니다.");
		} else {
			request.setAttribute("msg", "문의 등록에 실패했습니다.");
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
