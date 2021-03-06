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

/**
 * Servlet implementation class payCoinPlusServlet
 */
@WebServlet("/plusCoin.pay")
public class payCoinPlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payCoinPlusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int coin = Integer.parseInt(request.getParameter("coin"));
		Member m = new Member();
		
		int result = new PrjDeService().plusCoin(writer, coin);
		m = new PrjDeService().getCoinCount(writer);
		int getCoin = m.getCoin();
		PrintWriter out = response.getWriter();

	       if(m!= null) {
	          out.print(getCoin);
	       } else {
	    	   out.print("fail");
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
