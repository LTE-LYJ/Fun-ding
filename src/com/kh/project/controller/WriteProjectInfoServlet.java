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
 * Servlet implementation class WriteProjectInfoServlet
 */
@WebServlet("/writeInfo.pr")
public class WriteProjectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteProjectInfoServlet() {
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
		
		String allReward = request.getParameter("allReward");
		System.out.println("allReward : " + allReward);

		String[] splitReward1 = allReward.split("-");
		
		for (int i = 0; i < splitReward1.length; i++) {
			System.out.println(i + " : " + splitReward1[i]);
		}
		
		for (int i = 1; i < splitReward1.length; i++) {
			String[] splitReward2 = splitReward1[i].split("/");
			
			String rname = splitReward2[0];			
			String rcontent = splitReward2[1];			
			String rprice = splitReward2[2];
			
			System.out.println("rname" + i + " : " + rname);
			System.out.println("rcontent" + i + " : " + rcontent);
			System.out.println("rprice" + i + " : " + rprice);
			System.out.println("--------------------");
			
			Cookie rnameCookie = new Cookie("rname" + i, URLEncoder.encode(rname, "utf-8").replaceAll("\\+", "%20"));
			Cookie rcontentCookie = new Cookie("rcontent" + i, URLEncoder.encode(rcontent, "utf-8").replaceAll("\\+", "%20"));
			Cookie rpriceCookie = new Cookie("rprice" + i, URLEncoder.encode(rprice, "utf-8").replaceAll("\\+", "%20"));
			
			System.out.println("rnameCookie" + i + " : " + rnameCookie);
			System.out.println("rcontentCookie" + i + " : " + rcontentCookie);
			System.out.println("rpriceCookie" + i + " : " + rpriceCookie);
			System.out.println("--------------------");
			
			response.addCookie(rnameCookie);
			response.addCookie(rcontentCookie);
			response.addCookie(rpriceCookie);
			
		}
		
		request.getRequestDispatcher("views/project/writeProjectInfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
