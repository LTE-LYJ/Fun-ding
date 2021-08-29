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
		//private int memNo; //회원번호
		//private String memId; //아이디
		//private String memPwd; //비밀번호
		//private String memName; //이름
		//private String phone; //연락처
		//private String email; //이메일
		//private String address; //주소
		//private Date enrollDate; //회원가입일
		//private String status; //상태값(Y/N)
		//private int coin; //보유코인
		//private int prjNo; //프로젝트 번호
		
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
			
			System.out.println(userPwd);
			
			Member m = new Member();
			m.setMemId(userId);
			m.setMemPwd(userPwd);
			m.setMemName(userName);
			m.setPhone(phone);
			m.setEmail(email);
			m.setAddress(address);
			
			int result1 = new MemberService().insertMember(m);
			
			int memNo = new MemberService().selectMemNo(userId); //가입한 유저아이디의 memNo를 받아온다. 
			System.out.println(memNo);
			
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
				request.getSession().setAttribute("msg", "회원가입 성공");
				response.sendRedirect(request.getContextPath());
				
			} else {
				if(at != null) { //첨부 파일이 있는데 에러인 경우
					File failedFile = new File(savePath+at.getChangeName());
					failedFile.delete(); // 에러인 파일 삭제 
				}
				request.setAttribute("msg", "회원가입 실패");
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
