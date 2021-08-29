package com.kh.project_report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project_report.model.service.ProjectReportService;

/**
 * Servlet implementation class ProjectReportAnswerDeleteServlet
 */
@WebServlet("/answerDelete.pr")
public class ProjectReportAnswerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReportAnswerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prjReportNo = Integer.parseInt(request.getParameter("prjReportNo"));

		int result = new ProjectReportService().deleteAnswer(prjReportNo);

		if (result > 0) {
			int answer = new ProjectReportService().prjDeleteAnswer(prjReportNo);
			response.sendRedirect("views/project_report/projectReportListView");
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
