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
import com.kh.project_report.model.service.ProjectReportService;
import com.kh.project_report.model.vo.PrAnswer;
import com.kh.project_report.model.vo.ProjectReport;

/**
 * Servlet implementation class ProjectReportAnswerServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 2)
@WebServlet("/pAnswer.pr")
public class ProjectReportAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectReportAnswerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int prjReportNo = Integer.parseInt(request.getParameter("prjReportNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int prjNo = Integer.parseInt(request.getParameter("prjNo"));
		String writer = String.valueOf(((Member) request.getSession().getAttribute("loginUser")).getMemNo());
		Collection<Part> parts = request.getParts();

		StringBuilder builder = new StringBuilder();
		for (Part p : parts) {
			if (!p.getName().equals("file"))
				continue;
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
		builder.delete(builder.length()-1, builder.length());
		
		PrAnswer prAnswer = new PrAnswer(prjReportNo, title, content.replaceAll("\n", "<br>"), writer,
				builder.toString(), prjNo);
		int result = new ProjectReportService().answerProjectReport(prAnswer);
		if (result > 0) {
			 int answer = new ProjectReportService().answerCheck(prjReportNo);
			response.sendRedirect("views/project_report/projectReportAnswerDetailView?prjReportNo=" + prjReportNo);
		} else {
			request.setAttribute("msg", "프로젝트 번호가 일치하지 않습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}
}
