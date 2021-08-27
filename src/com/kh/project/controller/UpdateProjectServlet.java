package com.kh.project.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.vo.Member;
import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Creator;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.Reward;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateProjectServlet
 */
@WebServlet("/update.pr")
public class UpdateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cname = null, ccontent = null; // 창작자 이름, 창작자 소개
		String target = null, startDate = null, endDate = null; // 목표 금액, 펀딩 시작일, 펀딩 종료일
		int count = 0;
		String[][] rwList = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				request.setAttribute(c.getName(), c.getValue());

				System.out.println("c.getName() : " + c.getName());
				System.out.println("c.getValue() : " + c.getValue());
				System.out.println("--------------------");

				if (c.getName().contains("rname")) {
					count++;
				}

				System.out.println("count : " + count);
				rwList = new String[count][3];
			}

			for (Cookie c : cookies) {

				if (c.getName().equals("cname")) {
					cname = c.getValue();
					System.out.println("cname : " + cname);

				} else if (c.getName().equals("ccontent")) {
					ccontent = c.getValue();
					System.out.println("ccontent : " + ccontent);

				} else if (c.getName().equals("target")) {
					target = c.getValue();
					System.out.println("target : " + target);

				} else if (c.getName().equals("startDate")) {
					startDate = c.getValue();
					System.out.println("startDate : " + startDate);

				} else if (c.getName().equals("endDate")) {
					endDate = c.getValue();
					System.out.println("endDate : " + endDate);

				}

				for (int i = 0; i < count; i++) {
					if (c.getName().equals("rname" + (i + 1))) {
						rwList[i][0] = c.getValue();
						System.out.println("rwList[" + i + "][0] : " + rwList[i][0]);

					} else if (c.getName().equals("rcontent" + (i + 1))) {
						rwList[i][1] = c.getValue();
						System.out.println("rwList[" + i + "][1] : " + rwList[i][1]);

					} else if (c.getName().equals("rprice" + (i + 1))) {
						rwList[i][2] = c.getValue();
						System.out.println("rwList[" + i + "][2] : " + rwList[i][2]);

					}
				}
			}
		}

		if (ServletFileUpload.isMultipartContent(request)) { // enctype 이 multipart/form-data 로 잘 전송된 경우 (true)
			int maxSize = 10 * 1024 * 1024;

			String resources = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = resources + "\\upfiles_project\\";

			System.out.println("savePath : " + savePath);

			// MultipartRequest 객체 생성하기 (즉, 파일서버에 업로드하기)
			// MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());

			String category = multiRequest.getParameter("category");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");

			HttpSession session = request.getSession();
			Member loginUser = (Member) session.getAttribute("loginUser");
			int memNo = loginUser.getMemNo();
			System.out.println("memNo : " + memNo);
			
			int pno = Integer.parseInt(multiRequest.getParameter("pno"));

			Project p = new Project();
			p.setPrjCatName(category);
			p.setPrjTitle(title);
			p.setPrjContent(content);
			p.setPrjTarget(Double.parseDouble(target));
			p.setPrjStartDate(startDate);
			p.setPrjEndDate(endDate);
			p.setCreName(String.valueOf(memNo));
			p.setPrjNo(pno);

			Reward[] rList = new Reward[count];
			for (int i = 0; i < count; i++) {
				rList[i] = new Reward();
				rList[i].setRwName(rwList[i][0]);
				rList[i].setReContent(rwList[i][1]);
				rList[i].setRwPrice(Integer.parseInt(rwList[i][2]));
			}

			Creator c = new Creator();
			c.setCreName(cname);
			c.setCreContent(ccontent);
			c.setMemNo(String.valueOf(memNo));
			c.setPrjNo(pno);

			ProjectAttachment at = null;
			
			if(multiRequest.getOriginalFileName("upFile") != null) {// 새로 파일이 들어온경우
				
				at = new ProjectAttachment();
				at.setOriginName(multiRequest.getOriginalFileName("upFile"));
				at.setChangeName(multiRequest.getFilesystemName("upFile"));
				at.setFilePath(savePath);
				
				if(multiRequest.getParameter("originFile") != null ) {
					
					File deleteFile = new File(savePath + multiRequest.getParameter("originFile"));
					System.out.println("deleteFile   "+ deleteFile);
					deleteFile.delete();
					
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
				}else {
					at.setPrjNo(pno);
				}
			}

			int result = new ProjectService().updateProject(p, at, rList, c);

			if (result > 0) {
				request.getSession().setAttribute("msg", "프로젝트 업데이트 성공");
				response.sendRedirect("viewAll.pr");
			} else {
				if (at != null) {
					File failedFile = new File(savePath + at.getChangeName());
					failedFile.delete();
				}

				request.setAttribute("msg", "프로젝트 업데이트 실패");

				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}

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
