package com.internousdev.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.project1.dto.SearchFriendDTO;
import com.internousdev.project1.util.DBConnector;

public class SearchFriendDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	SearchFriendDTO searchFriendDTO = new SearchFriendDTO();

	String sql = "select * from login_user_transaction where login_id = ?";

	public SearchFriendDTO searchFriend(String loginUserId){

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				searchFriendDTO.setLoginUserId(rs.getString("login_id"));
				searchFriendDTO.setUserName(rs.getString("user_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return searchFriendDTO;
	}
}
