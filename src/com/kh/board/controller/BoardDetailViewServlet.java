package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardReply;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardDetailViewServlet
 */
@WebServlet("/views/board/boardDetailView")
public class BoardDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDetailViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		HttpSession session = request.getSession();
		int memNo = 0;
		String memName = "";
		if (request.getSession().getAttribute("loginUser") != null) {

			memNo = ((Member) session.getAttribute("loginUser")).getMemNo();
			memName = ((Member) session.getAttribute("loginUser")).getMemName();
		}

		BoardService service = new BoardService();
		int result = service.updateCount(boardNo);
		List<BoardReply> reply = new ArrayList<>();
		
		reply = service.getReplyList(boardNo);
		Board board = service.getBoard(boardNo);
		Board prevNo = service.getPrevBoard(boardNo);
		Board nextNo = service.getNextBoard(boardNo);
		
		
		request.setAttribute("writerNo", board.getBoardWriterNo());
		request.setAttribute("b", board);
		request.setAttribute("reply", reply);
		request.setAttribute("prev", prevNo);
		request.setAttribute("next", nextNo);
		request.setAttribute("memNo", memNo);
		request.setAttribute("memName", memName);
		request.getRequestDispatcher("/views/board/boardDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int writer = 0;
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		if (request.getSession().getAttribute("loginUser") != null) {

			writer = ((Member) session.getAttribute("loginUser")).getMemNo();
		}
		
		BoardReply reply = new BoardReply(content, boardNo, writer);
		int result = new BoardService().insertReply(reply);
		if(result > 0) {
			response.sendRedirect("/FundingPro/views/board/boardDetailView?boardNo="+boardNo);
		} 
		
	}

}
