package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class FollowOffAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String followCheck;
	public String execute() {
		
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		String sql = "DELETE from follow_list where user_id = ? AND followed_user_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ps.setString(2, session.get("searchFriendId").toString());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		setFollowCheck("off");
		session.put("followCheck", getFollowCheck());
		
		String ret = SUCCESS;
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
