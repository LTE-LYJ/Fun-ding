package com.kh.project.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.project.model.vo.PageInfo;
import com.kh.project.model.vo.Project;

public class ProjectDao {
	
	private Properties prop = new Properties();
	
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1); //컬럼명 적어도 되고 숫자 적어도 됨. 보통 컬럼명 적는 게 좋다
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Project> selectList(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
