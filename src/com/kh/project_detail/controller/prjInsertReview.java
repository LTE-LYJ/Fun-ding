package com.kh.project_detail.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.Review;

/**
 * Servlet implementation class prjInsertReview
 */
@WebServlet("/reinsert.de")
public class prjInsertReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prjInsertReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String content = request.getParameter("content");
	      int num = Integer.parseInt(request.getParameter("num"));
	      
	      int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
	       
	      
	      Review r = new Review();
	       
	      r.setReviewContent(content);
	      r.setPrjNo(num);
	      r.setMemId(String.valueOf(writer));
	      
	      int result = new PrjDeService().insertReview(r);
	       
	       PrintWriter out = response.getWriter();

	       if(result > 0) {
	          out.print("success");
	       } else {
	          out.print("fail");;
	       }
	       out.flush();
	       out.close();
	      
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
