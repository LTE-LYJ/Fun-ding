package com.kh.project_detail.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.project_detail.model.dao.PrjDeDao;
import com.kh.project_detail.model.vo.ProjectAsk;

public class PrjDeService {

	public ArrayList<ProjectAsk> selectList() {
		Connection conn = getConnection();
		
		ArrayList<ProjectAsk> askList = new PrjDeDao().selectList(conn);
		 close(conn);
		 
		return askList;
	}

}
