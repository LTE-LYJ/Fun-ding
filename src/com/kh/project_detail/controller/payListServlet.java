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
import com.kh.project.model.vo.ProjectCat;
import com.kh.project.model.vo.Reward;
import com.kh.project_detail.model.service.PrjDeService;
import com.kh.project_detail.model.vo.Pay;

/**
 * Servlet implementation class payListServlet
 */
@WebServlet("/paylist.pa")
public class payListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		Project project = new PrjDeService().selectPList(num); //프로젝트 정보
		ProjectCat projectCat = new PrjDeService().selectPreCatList(num); //프로젝트 인포
		ArrayList<ProjectAttachment> prjAttList = new PrjDeService().selectPrjAList(num);	// 프로젝트 사진 리스트
		ArrayList<Reward> rewordList  = new PrjDeService().selectRewordList(num); // 리워드 정보
		int writer = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		Member m = new Member();
		m = new PrjDeService().getCoinCount(writer);
		int coin = m.getCoin();
		ArrayList<Pay> payList = new PrjDeService().selectPayList(writer);
		System.out.println(payList);
		int opt = Integer.parseInt(request.getParameter("opt"));
		Reward re = new Reward();
		for(int i =0; i<rewordList.size();i++) {
			if(i==opt) {
				re = rewordList.get(i);
			}
		}
		String view ="";
		if(project != null) {
			request.setAttribute("project", project);
			request.setAttribute("projectCat", projectCat);
			request.setAttribute("prjAttList", prjAttList);
			request.setAttribute("rewordList", rewordList);
			request.setAttribute("payList", payList);
			request.setAttribute("re", re);
			request.setAttribute("opt", opt);
			HttpSession session = request.getSession();
			session.setAttribute("coin", coin);
			view ="views/project_detail/pay.jsp";
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
