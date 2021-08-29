package com.kh.project_detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.project.model.vo.Reward;
import com.kh.project_detail.model.service.PrjDeService;

/**
 * Servlet implementation class payRewordChange
 */
@WebServlet("/chageReword.pay")
public class payRewordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payRewordChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opt = Integer.parseInt(request.getParameter("opt"));
		int num = Integer.parseInt(request.getParameter("num"));
		ArrayList<Reward> rewordList  = new PrjDeService().selectRewordList(num); 
		Reward reword = new Reward();
		for(int i =0; i<rewordList.size();i++) {
			if(i==opt) {
				reword = rewordList.get(i);
			}
		}
		 response.setContentType("application/json; charset=UTF-8");
	     new Gson().toJson(reword, response.getWriter());
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
