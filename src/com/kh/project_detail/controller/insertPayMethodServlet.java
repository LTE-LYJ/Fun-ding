package com.kh.project_detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.Pay;

/**
 * Servlet implementation class insertPayMethodServlet
 */
@WebServlet("/insert.payM")
public class insertPayMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPayMethodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		String cardName = request.getParameter("cardName");
		
		String cardN1 = request.getParameter("cardN1");
		String cardN2 = request.getParameter("cardN2");
		String cardN3 = request.getParameter("cardN3");
		String cardN4 = request.getParameter("cardN4");
		Long cardN = Long.parseLong(cardN1+cardN2+cardN3+cardN4);
		
		String cardMo = request.getParameter("cardMo");
		String cardYe = request.getParameter("cardYe");
		String cardDate =cardYe+cardMo;
		String cardPwd = request.getParameter("cardPwd");
		String cardBirth = request.getParameter("cardBirth");
		
		Pay pay = new Pay();
		pay.setBank(cardName);
		pay.setCardNo(cardN);
		pay.setPayDate(cardDate);
		pay.setCardPwd(cardPwd);
		pay.setBirth(cardBirth);
		
		int result = new PrjDeService().insertPayMethod(writer, pay);
		ArrayList<Pay> list = new PrjDeService().selectPayList(writer);
			response.setContentType("application/json; charset=UTF-8");
		    new Gson().toJson(list, response.getWriter()); // 보여줄 리스트, 응답할 스트림
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
