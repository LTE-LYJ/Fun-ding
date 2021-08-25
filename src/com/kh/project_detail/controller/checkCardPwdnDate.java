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
import com.kh.project_detail.model.vo.Pay;

/**
 * Servlet implementation class checkCardPwdnDate
 */
@WebServlet("/checkPwdnDate.pay")
public class checkCardPwdnDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkCardPwdnDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		Long opt3 = Long.parseLong(request.getParameter("opt3"));
		String cardPwd = request.getParameter("cardP");
		String cardDate = request.getParameter("cardD");
		
		Pay pay = new Pay();
		pay = new PrjDeService().checkPwdnDate(writer, cardPwd, cardDate, opt3);
	       System.out.println(pay);
	       PrintWriter out = response.getWriter();

	       if(pay.getPayMNo()!= 0) {
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
