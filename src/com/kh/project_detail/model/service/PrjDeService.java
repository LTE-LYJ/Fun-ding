package com.kh.project_detail.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.attachment.model.vo.ProfileAttachment;
import com.kh.attachment.model.vo.ProjectAttachment;
import com.kh.member.model.vo.Member;
import com.kh.project.model.vo.Creator;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectCat;
import com.kh.project.model.vo.Reward;
import com.kh.project_detail.model.dao.PrjDeDao;
import com.kh.project_detail.model.vo.Funding;
import com.kh.project_detail.model.vo.Order;
import com.kh.project_detail.model.vo.PageInfo;
import com.kh.project_detail.model.vo.Pay;
import com.kh.project_detail.model.vo.ProjectAsk;
import com.kh.project_detail.model.vo.Review;

public class PrjDeService {

	public ArrayList<ProjectAsk> selectList(int num, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<ProjectAsk> askList = new PrjDeDao().selectList(conn, num, pi);
		 close(conn);
		 
		return askList;
	}

	public int insertAsk(ProjectAsk a) {
		Connection conn = getConnection();
		int result =new PrjDeDao().insertAsk(conn, a);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Review> selectReList(int num) {
		Connection conn = getConnection();
		ArrayList<Review> list = new PrjDeDao().selectReList(conn, num);
		close(conn);
		return list;
	}

	public int insertReview(Review r) {
		Connection conn = getConnection();
		
		int result =new PrjDeDao().insertReview(conn,r);
		if(result>0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Project selectPList(int num) {
		Connection conn = getConnection();
		Project p = null;
		p = new PrjDeDao().selectPList(conn, num); // 상세 내용 조회
		if(p!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return p;
	}

	public ArrayList<Reward> selectRewordList(int num) {
		Connection conn = getConnection();
		ArrayList<Reward> list = new PrjDeDao().selectRewordList(conn, num); // 상세 내용 조회
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

	public ProjectAsk detailPopupList(int askNum, int num) {
		Connection conn = getConnection();
		ProjectAsk ask = null;
		int result = new PrjDeDao().askIncreaseCount(conn, askNum, num); 
		
		ask = new PrjDeDao().detailPopupList(conn, askNum, num); // 상세 내용 조회
		if(ask!=null&&result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return ask;
	}

	public Creator selectCreList(int num, int writer) {
		Connection conn = getConnection();
		Creator c = null;
		c = new PrjDeDao().selectCreList(conn, num, writer); // 상세 내용 조회
		if(c!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return c;
	}

	public ProjectCat selectPreCatList(int num) {
		Connection conn = getConnection();
		ProjectCat pc = null;
		pc = new PrjDeDao().selectPreCatList(conn, num); // 상세 내용 조회
		if(pc!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return pc;
	}

	public int increaseReCount(int num) {
		Connection conn = getConnection();
		int result=0;
		result = new PrjDeDao().increaseReCount(conn, num); // 상세 내용 조회
		System.out.println(result);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getListCount(int num) {
		Connection conn = getConnection();
		
		int listCount = new PrjDeDao().getListCount(conn, num);
		close(conn);
		
		return listCount;
	}

	public int deleteReview(int reNum, int num, int writer) {
		Connection conn = getConnection();
		
		int result =new PrjDeDao().deleteReview(conn,reNum, num, writer);
		if(result>0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ProfileAttachment selectCreatorProfile(int num) {
		Connection conn = getConnection();
		ProfileAttachment createrPro = new PrjDeDao().selectCreatorProfile(conn, num);
		
		if(createrPro!=null) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return createrPro;
}

	public ArrayList<ProjectAttachment> selectPrjAList(int num) {
		Connection conn = getConnection();
		ArrayList<ProjectAttachment> list = new PrjDeDao().selectPrjAList(conn, num); // 상세 내용 조회
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

	public Project prjRecountSelect(int num) {
		Connection conn = getConnection();
		Project p = new PrjDeDao().prjRecountSelect(conn, num);
		close(conn);
		return p;
	}

	public ArrayList<Pay> selectPayList(int writer) {
		Connection conn = getConnection();
		ArrayList<Pay> list = new PrjDeDao().selectPayList(conn, writer); // 상세 내용 조회
		if(list!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

	public int insertPayMethod(int writer, Pay pay) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().insertPayMethod(conn, writer, pay);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

	public Pay checkPwdnDate(int writer, String cardPwd, String cardDate, Long opt3) {
		Connection conn = getConnection();
		
		Pay pay = new PrjDeDao().checkPwdnDate(conn, writer, cardPwd, cardDate, opt3);
		if(pay.getPayMNo()!=0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return pay;
	}

	public int plusCoin(int writer, int coin) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().insertPayMethod(conn, writer, coin);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Member getCoinCount(int writer) {
		Connection conn = getConnection();
		
		Member m = new PrjDeDao().getCoinCount(conn, writer);
		if(m!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return m;
	}

	public int insertFunding(Funding funding) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().insertFunding(conn, funding);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Funding findFundingNum(Funding funding) {
		Connection conn = getConnection();
		
		Funding f = new PrjDeDao().findFundingNum(conn, funding);
		if(f!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return f;
	}

	public int insertOrder(Order order, int fNum) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().insertOrder(conn, order, fNum);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int insertPay(Pay pay) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().insertOrder(conn, pay);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int setPrjCurrentAdd(int rewordPrice, int num) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().setPrjCurrentAdd(conn, rewordPrice, num);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int payCoin(int rewordPrice, int writer) {
		Connection conn = getConnection();
		
		int result = new PrjDeDao().payCoin(conn, rewordPrice, writer);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		}

	public Reward selectReword(int rewordNum) {
		Connection conn = getConnection();
		
		Reward re = new PrjDeDao().selectReword(conn, rewordNum);
		if(re!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return re;
		
		
	}

	public Order selectOrder(int fNum) {
		Connection conn = getConnection();
		
		Order or = new PrjDeDao().selectOrder(conn, fNum);
		if(or!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return or;
		
	}

	public int deleteAsk(int askNum, int num, int writer) {
		Connection conn = getConnection();
		
		int result =new PrjDeDao().deleteAsk(conn,askNum, num, writer);
		if(result>0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	}


