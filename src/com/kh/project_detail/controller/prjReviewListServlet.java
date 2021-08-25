package com.kh.project_detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectCat;
import com.kh.project_detail.model.service.PrjDeService;

/**
 * Servlet implementation class prjReviewListServlet
 */
@WebServlet("/proReview.list")
public class prjReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prjReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		Project project = new PrjDeService().selectPList(num);
		ProjectCat projectCat = new PrjDeService().selectPreCatList(num);
		ArrayList<ProjectAttachment> prjAttList = new PrjDeService().selectPrjAList(num);	// 프로젝트 사진 리스트
		
		String view ="";
		System.out.println(project);
		if(project != null) {
			request.setAttribute("project", project);
			request.setAttribute("projectCat", projectCat);
			request.setAttribute("prjAttList", prjAttList);
			view ="views/project_detail/projectDetailReview.jsp";
		}else {
			request.setAttribute("msg", "공지사항 조회에 실패했습니다.");
			view ="views/common/errorPage.jsp";
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
