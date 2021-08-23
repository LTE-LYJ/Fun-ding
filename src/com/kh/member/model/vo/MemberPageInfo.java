package com.kh.member.model.vo;


public class MemberPageInfo {
	private int listCount;		//총 개시글 개수
	private int currentPage;	//현재 페이지
	private int startPage;		//현재페이지의 시작페이징바
	private int endPage;		//현재페이지의 끝페이징바
	private int maxPage;		// 전체 페이지에서 가장 마지막 페이지
	private int pageLimit;		// 한 페이지 하단에 보여질 페이지 최대 개수
	private int boardLimit;	    // 한 페이지에서 보여지는 게시글 최대 갯수
	
	
	public MemberPageInfo() {
		// TODO Auto-generated constructor stub
	}


	public MemberPageInfo(int listCount, int currentPage, int startPage, int endPage, int maxPage, int pageLimit,
			int boardLimit) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getPageLimit() {
		return pageLimit;
	}


	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}


	public int getBoardLimit() {
		return boardLimit;
	}


	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}


	@Override
	public String toString() {
		return "MemberPageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", maxPage=" + maxPage + ", pageLimit=" + pageLimit + ", boardLimit="
				+ boardLimit + "]";
	}
	
	
	
}
