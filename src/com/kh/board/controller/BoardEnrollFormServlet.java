package com.kh.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.board.model.service.BoardCatService;
import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardCat;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardEnrollFormServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
				 maxFileSize = 1024 * 1024 * 50,
				 maxRequestSize = 1024 * 1024 * 50 * 2)
@WebServlet("/views/board/boardEnrollForm")
public class BoardEnrollFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEnrollFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardCat> cat = new BoardCatService().getBoardCatList();
		
		request.setAttribute("cat", cat);
		
		request.getRequestDispatcher("/views/board/boardEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("cate");
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
		
		Board board = new Board(title, content.replaceAll("\n", "<br>"), category, writer, builder.toString());
		int result = new BoardService().insertBoard(board);
		if(result>0){
			response.sendRedirect("boardListView");
		}
		else {
			System.out.println("에러");
		}
	}

}
