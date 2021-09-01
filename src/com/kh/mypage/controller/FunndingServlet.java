package com.kh.mypage.controller;

import com.kh.member.model.vo.Member;
import com.kh.mypage.model.service.MypageService;
import com.kh.mypage.model.vo.PageInfo;
import com.kh.mypage.model.vo.Project;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class FunndingServlet
 */
@WebServlet("/funding.mp")
public class FunndingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FunndingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	Member loginUser = (Member) request.getSession().getAttribute("loginUser");

        PageInfo pageInfo = PageInfo.fromRequest(request, new MypageService().getPrjListCount(Member.loginMember(request).getMemNo()));
        
        List<Project> list = new MypageService().selectFundingList(loginUser.getMemNo(), pageInfo);
        List<Project> running = new ArrayList<>();
        List<Project> closed = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date today = new Date();

        for (Project p : list) {
            Date endDate = sdf.parse(p.getPrjEndDate());
            if (endDate.getTime() < today.getTime()) {
                closed.add(p);
            } else {
                running.add(p);
            }
        }

        request.setAttribute("running", running);
        request.setAttribute("closed", closed);

        request.getRequestDispatcher("views/mypage/mypageFunding.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
