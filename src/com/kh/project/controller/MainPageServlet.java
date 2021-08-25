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
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Project> listAll = new ProjectService().selectAllList();
		ArrayList<Project> listPopular = new ProjectService().selectPopularList();
		ArrayList<Project> listNew = new ProjectService().selectNewList();
		ArrayList<Project> listClose = new ProjectService().selectCloseList();
		
		request.setAttribute("listAll", listAll);
		request.setAttribute("listPopular", listPopular);
		request.setAttribute("listNew", listNew);
		request.setAttribute("listClose", listClose);

		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
