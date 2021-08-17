package com.kh.project_detail.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.project_detail.model.vo.ProjectAsk;

public class PrjDeDao {
	
	private Properties prop = new Properties();
	
	public PrjDeDao() {
		String fileName = PrjDeDao.class.getResource("/com/sql/project_detail/projectdetail-query.properties").getPath();
		System.out.println("fileName   " + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProjectAsk> selectList(Connection conn) {
		ArrayList<ProjectAsk> askList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProjectAsk a =  new ProjectAsk();
				
				a.setPrjAskNo(rset.getInt("PRJ_ASK_NO"));
				a.setPrjAskTitle(rset.getString("PRJ_ASK_TITLE"));
				a.setMemId(rset.getString("MEM_ID"));
				a.setCount(rset.getInt("COUNT"));
				a.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				askList.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return askList;
	}

}
