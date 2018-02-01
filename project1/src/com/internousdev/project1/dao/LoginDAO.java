package com.internousdev.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.project1.dto.LoginDTO;
import com.internousdev.project1.util.DBConnector;

public class LoginDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getUserInfo(String loginUserId, String loginPassword){

		String sql = "SELECT * FROM login_user_transaction WHERE login_id=? AND login_pass=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				loginDTO.setUserId(rs.getString("id"));
				loginDTO.setLoginUserId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));


			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return loginDTO;
	}
}
