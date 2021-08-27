package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Creator;

/**
 * Servlet implementation class UpdateProjectCreatorServlet
 */
@WebServlet("/updateCreator.pr")
public class UpdateProjectCreatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectCreatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		Creator creator = new ProjectService().selectProjectCreator(pno);
		
		if(creator != null) {
			request.setAttribute("creator", creator);
			request.setAttribute("pno", pno);
			request.getRequestDispatcher("views/project/updateProjectCreator.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "수정할 정보를 불러오는 데 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
