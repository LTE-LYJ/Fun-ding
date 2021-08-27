package com.kh.notice.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

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

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet("/update.no")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = String.valueOf(((Member) request.getSession().getAttribute("loginUser")).getMemNo());
		System.out.println("===============");
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		System.out.println("writer : " + writer);
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
		Notice notice = new Notice(noticeNo, title, content.replaceAll("\n", "<br>"), writer, builder.toString());
		int result = new NoticeService().updateNotice(notice);
		response.sendRedirect("views/notice/noticeDetailView?noticeNo=" + noticeNo);

	}

}
