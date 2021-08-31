package com.kh.project_report.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;
import com.kh.project_report.model.service.ProjectReportService;
import com.kh.project_report.model.vo.ProjectReport;

/**
 * Servlet implementation class ProjectReportEnrollFormServlet
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 2)
@WebServlet("/views/project_report/projectReportEnrollForm")
public class ProjectReportEnrollFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReportEnrollFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/project_report/projectReportEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int prjNo = Integer.parseInt(request.getParameter("prjNo"));
		String writer = String.valueOf(((Member) request.getSession().getAttribute("loginUser")).getMemNo());
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for (Part p : parts) {
			if (!p.getName().equals("file"))
				continue;
			System.out.println("p : " + p.getSize());
			if (p.getSize() == 0)
				continue;

			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			InputStream fis = filePart.getInputStream();

			builder.append(fileName);
			builder.append(",");

			// "/upload/" -> "c:/temp/upload"
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			File path = new File(realPath);
			if (!path.exists()) {
				path.mkdirs();
			}

			String filePath = realPath + File.separator + fileName;

			FileOutputStream fos = new FileOutputStream(filePath);

			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.close();
			fis.close();


		}
		ProjectReport prjReport = new ProjectReport(title, content.replaceAll("\n", "<br>"), writer, builder.toString(), prjNo);
		int result = new ProjectReportService().insertProjectReport(prjReport);
		if(result >0) {
			System.out.println("커밋성공");
			response.sendRedirect("projectReportListView");
		}else {
			request.setAttribute("msg", "프로젝트 번호가 일치하지 않습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

}
