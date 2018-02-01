package com.internousdev.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.project1.util.DBConnector;


public class AlReadCheckDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	List<String> alReadDTO = new ArrayList<String>();

	public List<String> getAlReadCheck(String loginUserId){

		String sql = "SELECT * FROM already_read WHERE user_id = ? ";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				alReadDTO.add(rs.getString("book_id"));
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return alReadDTO;
	}
}
