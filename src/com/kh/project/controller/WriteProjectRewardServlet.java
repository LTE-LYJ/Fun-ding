package com.kh.project.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteProjectRewardServlet
 */
@WebServlet("/writeReward.pr")
public class WriteProjectRewardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteProjectRewardServlet() {
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

		String target = request.getParameter("target");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		System.out.println("target : " + target);
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		System.out.println("--------------------");

		Cookie targetCookie = new Cookie("target", URLEncoder.encode(target, "utf-8").replaceAll("\\+", "%20"));
		Cookie startDateCookie = new Cookie("startDate", URLEncoder.encode(startDate, "utf-8").replaceAll("\\+", "%20"));
		Cookie endDateCookie = new Cookie("endDate", URLEncoder.encode(endDate, "utf-8").replaceAll("\\+", "%20"));

		System.out.println("targetCookie : " + targetCookie);
		System.out.println("startDateCookie : " + startDateCookie);
		System.out.println("endDateCookie : " + endDateCookie);
		System.out.println("--------------------");

		response.addCookie(targetCookie);
		response.addCookie(startDateCookie);
		response.addCookie(endDateCookie);
		
		request.getRequestDispatcher("views/project/writeProjectReward.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
