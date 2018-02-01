package com.internousdev.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.project1.util.DBConnector;
import com.internousdev.project1.util.DateUtil;

public class RegItemCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO item_info(user_id, item_category, item_name, item_price, item_count, item_total_price, item_search_word, insert_date) VALUES (?,?,?,?,?,?,?,?)";

	public void regItem(String loginUserId, String itemCategory, String itemName, int itemPrice, int itemCount, int itemTotalPrice, String itemSearchWord) throws SQLException{
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, itemCategory);
			ps.setString(3, itemName);
			ps.setInt(4, itemPrice);
			ps.setInt(5, itemCount);
			ps.setInt(6, itemTotalPrice);
			ps.setString(7, itemSearchWord);
			ps.setString(8, dateUtil.getDate());

			ps.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
