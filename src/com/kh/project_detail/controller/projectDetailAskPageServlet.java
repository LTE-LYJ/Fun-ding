package com.kh.project_detail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.vo.Project;
import com.kh.project_detail.model.service.PrjDeService;

/**
 * Servlet implementation class projectDetailReviewPageServlet
 */
@WebServlet("/writeAsk.de")
public class projectDetailAskPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectDetailAskPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		Project project = new PrjDeService().selectPList(num);
		
		String view ="";
		System.out.println(project);
		if(project != null) {
			request.setAttribute("project", project);
			view ="views/project_detail/projectDetailAskNewPop.jsp";
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
