package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.util.DBConnector;
import com.internousdev.project1.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class FollowAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String followCheck;
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();

	public String execute(){
		String ret = SUCCESS;

		String sql = "INSERT INTO follow_list (user_id, user_name ,followed_user_id, followed_user_name, insert_date) VALUES (?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ps.setString(2, session.get("userName").toString());
			ps.setString(3, session.get("searchFriendId").toString());
			ps.setString(4, session.get("searchFriendName").toString());
			ps.setString(5, dateUtil.getDate());

			ps.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		setFollowCheck("on");
		session.put("followCheck", getFollowCheck());
		
		return ret;
	}

	
	
	public String getFollowCheck() {
		return followCheck;
	}



	public void setFollowCheck(String followCheck) {
		this.followCheck = followCheck;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
