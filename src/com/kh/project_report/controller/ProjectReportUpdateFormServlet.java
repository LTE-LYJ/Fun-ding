package com.kh.project_report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;
import com.kh.project.model.service.ProjectService;
import com.kh.project_report.model.service.ProjectReportService;
import com.kh.project_report.model.vo.ProjectReport;

/**
 * Servlet implementation class ProjectReportUpdateFormServlet
 */
@WebServlet("/views/project_report/projectReportUpdateForm")
public class ProjectReportUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReportUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prjReportNo = Integer.parseInt(request.getParameter("prjReportNo"));
		ProjectReport prjReport = new ProjectReportService().selectUpdateProjectReport(prjReportNo);
		String view = "";
		if (prjReport != null) {
			request.setAttribute("pr", prjReport);
			request.setAttribute("prjReportNo", prjReportNo);
			view = "/views/project_report/projectReportUpdateForm.jsp";
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
