package com.kh.mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.mypage.model.service.MypageService;
import com.oreilly.servlet.MultipartRequest;
import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class UpdateInfoOkServlet
 */
@WebServlet("/updateInfoOk.mp")
public class UpdateInfoOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member updateMem = new MypageService().updateMember(new Member(memId, memName, phone, email, address));
		
		if(updateMem != null) {
			request.getSession().setAttribute("msg", "성공적으로 회원 정보를 수정하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem); //최신 정보
			response.sendRedirect(request.getContextPath());
		}else {
			
			request.setAttribute("msg", "회원 정보 수정에 실패했습니다");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}*/
		request.setCharacterEncoding("UTF-8");
		
		
		//
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 *1024;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			
			String savePath = resources + "\\upfiles_profile\\";
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			String memId = multiRequest.getParameter("memId");
			String memName = multiRequest.getParameter("memName");
			String phone = multiRequest.getParameter("phone");
			String email = multiRequest.getParameter("email");
			String address = multiRequest.getParameter("address");
			
			Member m = new Member();
			m.setMemId(memId);
			m.setMemName(memName);
			m.setPhone(phone);
			m.setEmail(email);
			m.setAddress(address);
			
			
			
			int result = new MemberService().insertMember(m);
			
			int memNo = new MemberService().selectMemNo(memId);
			
			ProfileAttachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				
				at = new ProfileAttachment();
				
				at.setOriginName(multiRequest.getOriginalFileName("upFile"));
				at.setChangeName(multiRequest.getFilesystemName("upFile"));
				at.setFilePath(savePath);
				
				
				if(multiRequest.getParameter("originFile") != null ) {
					
					File deleteFile = new File(savePath + multiRequest.getParameter("originFile"));
					System.out.println("deleteFile   "+ deleteFile);
					deleteFile.delete();
					
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
				}
				
				
			}
			
			Member updateMem = new MypageService().updateMember(new Member(memId, memName, phone, email, address));
			
			int result2 = new MemberService().insertAttachment(at, memNo);
			
			
			if(result2 > 0) {
				request.getSession().setAttribute("msg", "회원정보 변경");
				response.sendRedirect(request.getContextPath());
				
			} else {
				
				if(at != null) {
					File failedFile = new File(savePath+at.getChangeName());
					
					failedFile.delete();
				}
				request.setAttribute("msg", "회원정보 변경 실패");
				
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
