package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.FriendReadDAO;
import com.internousdev.project1.dto.FollowListDTO;
import com.internousdev.project1.dto.FriendReadDTO;
import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class FollowUserInfoAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private FriendReadDAO friendReadDAO = new FriendReadDAO();
	private List<FriendReadDTO> friendReadDTOList = new ArrayList<FriendReadDTO>();
	private String followCheck;
	private int flCheckNum;
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public String execute(){
		 List<FollowListDTO> followList = ( List<FollowListDTO>) session.get("followList");
		 session.put("searchFriendName", followList.get(flCheckNum).getFollowUserName().toString());
		 session.put("searchFriendId", followList.get(flCheckNum).getFollowUserId().toString());

		friendReadDTOList = friendReadDAO.getFriendRead(followList.get(flCheckNum).getFollowUserId().toString());

		session.put("friendReadDTOList", friendReadDTOList);

		String sql = "select * from follow_list where user_id = ? AND followed_user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ps.setString(2, followList.get(flCheckNum).getFollowUserId().toString());
			ResultSet rs = ps.executeQuery();

			if(rs.next() == true) {
				setFollowCheck("on");
			}else {
				setFollowCheck("off");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

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




	public int getFlCheckNum() {
		return flCheckNum;
	}



	public void setFlCheckNum(int flCheckNum) {
		this.flCheckNum = flCheckNum;
	}



	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
