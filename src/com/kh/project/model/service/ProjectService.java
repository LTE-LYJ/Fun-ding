package com.kh.project.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.project.model.dao.ProjectDao;
import com.kh.project.model.vo.PageInfo;
import com.kh.project.model.vo.Project;

public class ProjectService {
	
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProjectDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Project> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectList(conn, pi);
		close(conn);
		return list;
	}

	

}
