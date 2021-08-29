package com.kh.project_report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.project_report.model.service.ProjectReportService;
import com.kh.project_report.model.vo.PrAnswer;
import com.kh.project_report.model.vo.ProjectReport;

/**
 * Servlet implementation class ProjectReportAnswerDetailViewServlet
 */
@WebServlet("/views/project_report/projectReportAnswerDetailView")
public class ProjectReportAnswerDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReportAnswerDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prjReportNo = Integer.parseInt(request.getParameter("prjReportNo"));
		HttpSession session = request.getSession();
		int memNo = 0;
		if(request.getSession().getAttribute("loginUser") != null) {
			
			memNo = ((Member)session.getAttribute("loginUser")).getMemNo();
			}
		ProjectReportService service = new ProjectReportService();
		int result = service.updateAnswerCount(prjReportNo);
		PrAnswer prAnswer = service.getPrAnswer(prjReportNo);
		
		request.setAttribute("writerNo", prAnswer.getPrjReportWriter());
		request.setAttribute("p", prAnswer);
		request.setAttribute("memNo", memNo);
		
		request.getRequestDispatcher("/views/project_report/projectReportAnswerDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
