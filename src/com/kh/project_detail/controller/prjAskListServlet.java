package com.kh.project_detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectCat;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.PageInfo;
import com.kh.project_detail.model.vo.ProjectAsk;

/**
 * Servlet implementation class prjAskListServlet
 */
@WebServlet("/proAsk.list")
public class prjAskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prjAskListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		// ---------------- 페이징 처리 -----------------
				int listCount;			// 총 게시글 갯수
				int currentPage;		// 현재 페이지 (즉, 요청한 페이지)
				int startPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 시작 수 
				int endPage=0;			// 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
				int maxPage;			// 전체 페이지에서의 가장 마지막 페이지
				
				int pageLimit;			// 한 페이지 하단에 보여질 페이지 최대 갯수
				int boardLimit;			// 한 페이지에 보여질 게시글 최대 갯수
				
				listCount = new PrjDeService().getListCount(num);
				currentPage = 1;
				
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				pageLimit = 10;
				boardLimit = 10;
				maxPage = (int)Math.ceil((double)listCount/boardLimit);
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
				
				if(maxPage > endPage) {
					endPage = maxPage;
				}
				PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);
				ArrayList<ProjectAsk> askList = new PrjDeService().selectList(num, pi);
				Project project = new PrjDeService().selectPList(num);
				ProjectCat projectCat = new PrjDeService().selectPreCatList(num); 
				ArrayList<ProjectAttachment> prjAttList = new PrjDeService().selectPrjAList(num);	// 프로젝트 사진 리스트
				request.setAttribute("pi", pi);
				request.setAttribute("askList", askList);
				request.setAttribute("project", project);
				request.setAttribute("prjAttList", prjAttList);
				request.setAttribute("projectCat", projectCat);
				System.out.println(pi);
				System.out.println(askList);
				System.out.println(project);
				System.out.println(prjAttList);
				System.out.println(projectCat);
				RequestDispatcher view = request.getRequestDispatcher("views/project_detail/projectDetailAsk.jsp");
				view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
