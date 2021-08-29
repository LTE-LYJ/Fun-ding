package com.kh.project.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Project;

/**
 * Servlet implementation class UpdateProjectPlanServlet
 */
@WebServlet("/updatePlan.pr")
public class UpdateProjectPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// Cookie 선언
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				request.setAttribute(c.getName(), c.getValue());

				System.out.println("c.getName() : " + c.getName());
				System.out.println("c.getValue() : " + c.getValue());
				System.out.println("--------------------");
			}
		}

		String cname = request.getParameter("cname");
		String ccontent = request.getParameter("ccontent");

		System.out.println("cname : " + cname);
		System.out.println("ccontent : " + ccontent);
		System.out.println("--------------------");

		Cookie cnameCookie = new Cookie("cname", URLEncoder.encode(cname, "utf-8").replaceAll("\\+", "%20"));
		Cookie ccontentCookie = new Cookie("ccontent", URLEncoder.encode(ccontent, "utf-8").replaceAll("\\+", "%20"));

		System.out.println("cnameCookie : " + cnameCookie);
		System.out.println("ccontentCookie : " + ccontentCookie);
		System.out.println("--------------------");

		response.addCookie(cnameCookie);
		response.addCookie(ccontentCookie);
		
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		Project project = new ProjectService().selectProjectPlan(pno);
		
		if(project != null) {
			request.setAttribute("project", project);
			request.setAttribute("pno", pno);
			request.getRequestDispatcher("views/project/updateProjectPlan.jsp").forward(request, response);
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
