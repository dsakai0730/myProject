package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dto.FollowListDTO;
import com.internousdev.project1.dto.FollowerListDTO;
import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class FriendPageAction extends ActionSupport implements SessionAware{

	private String retMessage;
	private String flexistMessage;
	private String flerexistMessage;
	private List<FollowListDTO>followList = new ArrayList<FollowListDTO>();
	private List<FollowerListDTO>followerList = new ArrayList<FollowerListDTO>();
	public Map<String, Object> session;

	public String execute(){
		String ret = SUCCESS;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM follow_list WHERE user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				FollowListDTO dto = new FollowListDTO();
				dto.setFollowUserId(rs.getString("followed_user_id"));
				dto.setFollowUserName(rs.getString("followed_user_name"));
				followList.add(dto);
			}

			if(followList.isEmpty()){
				setFlexistMessage("none");
			}else{
				setFlexistMessage("exist");
			}

			session.put("followList", followList);
			session.put("flexistMessage" ,getFlexistMessage());


		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBConnector db2 = new DBConnector();
		Connection con2 = db2.getConnection();
		
		String sql2 = "SELECT * FROM follow_list WHERE followed_user_id = ?";
		try {
			PreparedStatement ps2 = con2.prepareStatement(sql2);
			ps2.setString(1, session.get("loginUserId").toString());
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next()) {
				FollowerListDTO dto2 = new FollowerListDTO();
				dto2.setFollowerId(rs2.getString("user_id"));
				dto2.setFollowerName(rs2.getString("user_name"));
				followerList.add(dto2);
			}
			
			if(followerList.isEmpty()) {
				setFlerexistMessage("none");
			}else {
				setFlerexistMessage("exist");
			}
			
			
			session.put("followerList", followerList);
			session.put("flerexistMessage", getFlerexistMessage());
			
		}catch(SQLException f) {
			f.printStackTrace();
		}
		try {
			con2.close();
		}catch(SQLException f) {
			f.printStackTrace();
		}
		

		return ret;
	}



	public String getRetMessage() {
		return retMessage;
	}



	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}




	public String getFlexistMessage() {
		return flexistMessage;
	}



	public void setFlexistMessage(String flexistMessage) {
		this.flexistMessage = flexistMessage;
	}

	


	public String getFlerexistMessage() {
		return flerexistMessage;
	}



	public void setFlerexistMessage(String flerexistMessage) {
		this.flerexistMessage = flerexistMessage;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
