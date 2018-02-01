package com.internousdev.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.project1.util.DBConnector;
import com.internousdev.project1.util.DateUtil;

public class AlReadDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();

	String sql = "INSERT INTO already_read (user_id, book_id,  book_img, book_title, book_author, book_published_date, book_description,insert_date) VALUES (?,?,?,?,?,?,?,?)";
	public void alReadBook(String loinUserId, String bookId, String img, String title, String author, String publishedDate, String description) throws SQLException{

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loinUserId);
			ps.setString(2, bookId);
			ps.setString(3, img);
			ps.setString(4, title);
			ps.setString(5, author);
			ps.setString(6, publishedDate);
			ps.setString(7, description);
			ps.setString(8, dateUtil.getDate());

			ps.execute();

		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}

	}
}
