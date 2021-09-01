package com.kh.mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.mypage.model.service.MypageService;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpdateInfoOkServlet
 */
@WebServlet("/updateInfoOk.mp")
public class UpdateInfoOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_MULTIPART_SIZE = 10 * 1024 *1024;
	private static final String PROFILE_PATH = "\\upfiles_profile\\";

	private static final MemberService memberService = new MemberService();

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
		
		if (!ServletFileUpload.isMultipartContent(request)) {
			fail(request, response);
			return;
		}

		String savePath = request.getSession().getServletContext().getRealPath("/resources") + PROFILE_PATH;
		MultipartRequest multipart = new MultipartRequest(
				request,
				savePath,
				MAX_MULTIPART_SIZE,
				"UTF-8",
				new MyFileRenamePolicy()
		);

		String memId = multipart.getParameter("memId");
		String memName = multipart.getParameter("memName");
		String phone = multipart.getParameter("phone");
		String email = multipart.getParameter("email");
		String address = multipart.getParameter("address");

		Member updateMem = new MypageService().updateMember(new Member(memId, memName, phone, email, address));

		if (updateMem == null) {
			fail(request, response);
			return;
		}

		if (multipart.getOriginalFileName("profileImage") != null) {
			removeProfileAttachmentIfExists(memId, updateMem.getMemNo(), savePath);

			String originName = multipart.getOriginalFileName("profileImage");
			String changeName = multipart.getFilesystemName("profileImage");

			ProfileAttachment at = new ProfileAttachment();
			at.setFilePath(savePath);
			at.setOriginName(originName);
			at.setChangeName(changeName);

			memberService.insertAttachment(at, updateMem.getMemNo());
			request.getSession().setAttribute("at", at);
		}

		request.getSession().setAttribute("msg", "회원 정보가 수정되었습니다.");
		request.getSession().setAttribute("loginUser", updateMem);
		
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void fail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "회원 정보 수정에 실패했습니다");

		RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
		view.forward(request, response);
	}

	private void removeProfileAttachmentIfExists(String userId, int memNo, String savePath) {
		ProfileAttachment profileAttachment = memberService.memberProfile(userId);
		if (profileAttachment == null) return;

		new File(savePath + profileAttachment.getChangeName()).delete();
		memberService.removeAttachment(memNo);
	}
}
