package com.kh.project_report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.vo.Notice;
import com.kh.project_report.model.service.ProjectReportService;
import com.kh.project_report.model.vo.ProjectReport;

/**
 * Servlet implementation class ProjectReportListViewServlet
 */
@WebServlet("/views/project_report/projectReportListView")
public class ProjectReportListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReportListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		int memNo = 0;
		HttpSession session = request.getSession();
		if(request.getSession().getAttribute("loginUser") != null) {
			
		memNo = ((Member)session.getAttribute("loginUser")).getMemNo();
		}
		
		String field = "PRJ_REPORT_TITLE";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}
		String query = "";

		if (query_ != null && !query_.equals("")) {
			query = query_;
		}

		int page = 1;

		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		ProjectReportService service = new ProjectReportService();
		List<ProjectReport> list = service.getProjectReportList(field, query, page);
		
		
		int count = service.getProjectReportCount(field,query);
		
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("memNo", memNo);
		request.getRequestDispatcher("/views/project_report/projectReportListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
