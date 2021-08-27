package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Project;

/**
 * Servlet implementation class UpdateProjectInfoServlet
 */
@WebServlet("/updateInfo.pr")
public class UpdateProjectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectInfoServlet() {
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

			Cookie rnameCookie = new Cookie("rname" + i, rname);
			Cookie rcontentCookie = new Cookie("rcontent" + i, rcontent);
			Cookie rpriceCookie = new Cookie("rprice" + i, rprice);

			System.out.println("rnameCookie" + i + " : " + rnameCookie);
			System.out.println("rcontentCookie" + i + " : " + rcontentCookie);
			System.out.println("rpriceCookie" + i + " : " + rpriceCookie);
			System.out.println("--------------------");

			response.addCookie(rnameCookie);
			response.addCookie(rcontentCookie);
			response.addCookie(rpriceCookie);

		}
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		Project project = new ProjectService().selectProjectInfo(pno);
		ProjectAttachment at = new ProjectService().selectAttachment(pno);
		
		if(project != null) {
			request.setAttribute("project", project);
			request.setAttribute("at", at);
			request.setAttribute("pno", pno);
			request.getRequestDispatcher("views/project/updateProjectInfo.jsp").forward(request, response);
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
