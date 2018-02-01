package com.internousdev.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.project1.dto.FriendReadDTO;
import com.internousdev.project1.util.DBConnector;

public class FriendReadDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	List<FriendReadDTO> friendReadDTOList = new ArrayList<FriendReadDTO>();

	public List<FriendReadDTO> getFriendRead(String loginUserId){

		String sql = "SELECT * FROM already_read WHERE user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				FriendReadDTO dto = new FriendReadDTO();
				dto.setBookId(rs.getString("book_id"));
				dto.setImg(rs.getString("book_img"));
				dto.setTitle(rs.getString("book_title"));
				dto.setAuthor(rs.getString("book_author"));
				dto.setPublishedDate(rs.getString("book_published_date"));
				dto.setDescription(rs.getString("book_description"));
				friendReadDTOList.add(dto);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return friendReadDTOList;


	}
}

