package com.kh.project_detail.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.ProjectAsk;

/**
 * Servlet implementation class deleteAskServlet
 */
@WebServlet("/delete.ask")
public class deleteAskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int askNum = Integer.parseInt(request.getParameter("askNum"));
		int num = Integer.parseInt(request.getParameter("num"));
		int result = new PrjDeService().deleteAsk(askNum, num, writer);
		
		String view ="";
		if(result >0) {
			view ="views/project_detail/close.jsp";
			//view ="views/project_detail/projectDetailAskPop.jsp";
		}else {
			request.setAttribute("msg", "공지사항 조회에 실패했습니다.");
			view ="views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
