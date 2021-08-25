package com.kh.project_detail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.project.model.vo.Creator;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectCat;
import com.kh.project.model.vo.Reward;
import com.kh.project_detail.model.service.PrjDeService;

/**
 * Servlet implementation class prjInfoServlet
 */
@WebServlet("/proInfo.list")
public class prjInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prjInfoListServlet() {
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
		Creator creator = new PrjDeService().selectCreList(num, project.getCreNo());// 창작자 정보 
		ArrayList<Reward> rewordList  = new PrjDeService().selectRewordList(num); // 리워드 정보
		ProfileAttachment createrPro = new PrjDeService().selectCreatorProfile(num);// 크리에이터 이미지
		
		String view ="";
		if(project != null) {
			request.setAttribute("project", project);
			request.setAttribute("projectCat", projectCat);
			request.setAttribute("prjAttList", prjAttList);
			request.setAttribute("creator", creator);
			request.setAttribute("rewordList", rewordList);
			request.setAttribute("createrPro", createrPro);
			view ="views/project_detail/projectDetailInfo.jsp";
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
