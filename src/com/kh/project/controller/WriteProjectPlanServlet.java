package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteProjectPlanServlet
 */
@WebServlet("/writePlan.pr")
public class WriteProjectPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteProjectPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		Cookie cnameCookie = new Cookie("cname", cname);
		Cookie ccontentCookie = new Cookie("ccontent", ccontent);

		System.out.println("cnameCookie : " + cnameCookie);
		System.out.println("ccontentCookie : " + ccontentCookie);
		System.out.println("--------------------");

		response.addCookie(cnameCookie);
		response.addCookie(ccontentCookie);
		
		request.getRequestDispatcher("views/project/writeProjectPlan.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
