package com.kh.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.PageInfo;
import com.kh.project.model.vo.Project;

/**
 * Servlet implementation class ViewNewServlet
 */
@WebServlet("/viewNew.pr")
public class ViewNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ---------------- 페이징 처리 -----------------
		int listCount; // 총 게시글 갯수
		int currentPage; // 현재 페이지 (즉, 요청한 페이지)
		int startPage; // 현재 페이지에 하단에 보여지는 페이징 바의 시작 수
		int endPage; // 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
		int maxPage; // 전체 페이지에서의 가장 마지막 페이지

		int pageLimit; // 한 페이지 하단에 보여질 페이지 최대 갯수
		int boardLimit; // 한 페이지에 보여질 게시글 최대 갯수

		listCount = new ProjectService().getNewListCount();

		currentPage = 1;

		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		pageLimit = 10;

		boardLimit = 6;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);

		ArrayList<Project> list = new ProjectService().selectNewList(pi);

		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("allListCount", listCount);

		request.getRequestDispatcher("views/project/viewNewProject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
