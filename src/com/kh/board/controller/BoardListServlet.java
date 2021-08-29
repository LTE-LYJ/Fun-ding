package com.kh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardCatService;
import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.BoardCat;
import com.kh.board.model.vo.BoardView;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/views/board/boardListView")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		String cate_ = request.getParameter("c");
		int memNo = 0;
		HttpSession session = request.getSession();
		if(request.getSession().getAttribute("loginUser") != null) {
			
		memNo = ((Member)session.getAttribute("loginUser")).getMemNo();
		}
		
		String field = "BOARD_TITLE";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}
		String query = "";

		if (query_ != null && !query_.equals("")) {
			query = query_;
		}

		int page = 1;

		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		String  cate = "";
		if(cate_ != null && !cate_.equals("")) {
			cate = cate_;
			}
		
		// 카테고리 리스트
		List<BoardCat> cat = new BoardCatService().getBoardCatList();

		// 게시판 리스트
		BoardService service = new BoardService();
		List<BoardView> list = service.getBoardList(field, query, page, cate);
		
		
		int count = service.getBoardCount(field,query);
		
		request.setAttribute("cat", cat);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("memNo", memNo);
		request.getRequestDispatcher("/views/board/boardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
