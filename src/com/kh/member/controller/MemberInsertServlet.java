package com.kh.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 *1024;
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = resources + "\\upfiles_profile\\";
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			String userId = multiRequest.getParameter("userId");
			String userPwd = multiRequest.getParameter("userPwd");
			String userName = multiRequest.getParameter("userName");
			String phone = multiRequest.getParameter("phone");
			String email = multiRequest.getParameter("email");
			String address = multiRequest.getParameter("address1");
			
			Member m = new Member();
			m.setMemId(userId);
			m.setMemPwd(userPwd);
			m.setMemName(userName);
			m.setPhone(phone);
			m.setEmail(email);
			m.setAddress(address);
			
			int result1 = new MemberService().insertMember(m);
			
			int memNo = new MemberService().selectMemNo(userId); //????????? ?????????????????? memNo??? ????????????. 
			
			ProfileAttachment at = null;
			
			if(multiRequest.getOriginalFileName("file1") != null) {
				String originName = multiRequest.getOriginalFileName("file1");
				
				String changeName = multiRequest.getFilesystemName("file1");
				
				System.out.println("originName" + originName);
				System.out.println("changeName" + changeName);
				
				at = new ProfileAttachment();
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
				
				int result2 = new MemberService().insertAttachment(at, memNo);
			}
			
			if(result1 > 0) {
				request.getSession().setAttribute("msg", "???????????? ??????");
				response.sendRedirect(request.getContextPath());
				
			} else {
				if(at != null) { //?????? ????????? ????????? ????????? ??????
					File failedFile = new File(savePath+at.getChangeName());
					failedFile.delete(); // ????????? ?????? ?????? 
				}
				request.setAttribute("msg", "???????????? ??????");
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
