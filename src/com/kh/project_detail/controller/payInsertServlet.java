package com.kh.project_detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.member.model.vo.Member;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.Reward;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.Funding;
import com.kh.project_detail.model.vo.Order;
import com.kh.project_detail.model.vo.Pay;

/**
 * Servlet implementation class payInsertServlet
 */
@WebServlet("/payInsert.pay")
public class payInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int num =Integer.parseInt(request.getParameter("prjNum"));
		System.out.println(num);
		int rewordNum = Integer.parseInt(request.getParameter("reNum"));
		int rewordPrice = Integer.parseInt(request.getParameter("rePrice"));
		
		Funding funding = new Funding();
			funding.setMemNo(writer);
			funding.setPrjNo(num);
			funding.setRwNo(rewordNum);
		int result1= new PrjDeService().insertFunding(funding);
		Funding f = new Funding();
		f= new PrjDeService().findFundingNum(funding);
		int fNum = f.getFdNo(); //후원번호
		
		String deliName =request.getParameter("userNameNew");
		String deliPhone =request.getParameter("userPhoneNew");
		String deliReci =request.getParameter("receiver");
		String deliAddr =request.getParameter("deliAddr");
		Order order = new Order(deliName, deliPhone, deliReci, deliAddr);
		int result2 =  new PrjDeService().insertOrder(order, fNum);
		Pay pay = new Pay(writer, num, rewordPrice, fNum );
		System.out.println(order);
		System.out.println(pay);
		int result3 = new PrjDeService().insertPay(pay);
		int result4 = new PrjDeService().setPrjCurrentAdd(rewordPrice, num);
		int result5 = new PrjDeService().payCoin(rewordPrice, writer);
		
		Project project = new PrjDeService().selectPList(num);
		Reward reword = new PrjDeService().selectReword(rewordNum);
		System.out.println(reword);
		
		Member m = new Member();
		m = new PrjDeService().getCoinCount(writer);
		int coin = m.getCoin();
		
		Order orderde = new PrjDeService().selectOrder(fNum);
		ArrayList<ProjectAttachment> prjAttList = new PrjDeService().selectPrjAList(num);
		response.setCharacterEncoding("UTF-8");
		
		String view ="";
		if(project != null) {
			request.setAttribute("project", project);
			request.setAttribute("reword", reword);
			request.setAttribute("orderde", orderde);
			request.setAttribute("prjAttList", prjAttList);
			HttpSession session = request.getSession();
			session.setAttribute("coin", coin);
			view ="views/project_detail/payFinish.jsp";
		}else {
			request.setAttribute("msg", "프로젝트 조회에 실패했습니다.");
			view ="views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
