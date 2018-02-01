package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.AlReadCheckDAO;
import com.internousdev.project1.dto.LoginDTO;
import com.internousdev.project1.dto.SearchBookDTO;
import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class OffReadAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private List<String> alReadDTO = new ArrayList<String>();
	private AlReadCheckDAO alReadCheckDAO = new AlReadCheckDAO();
	private String alReadCheckMessage;

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	LoginDTO loginDTO = new LoginDTO();

	public String execute(){

		String sql = "DELETE FROM already_read WHERE user_id = ? AND book_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ps.setString(2, session.get("checkId").toString());
			ps.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		List<SearchBookDTO> bookList = (List<SearchBookDTO>) session.get("searchBookDTOList");

		alReadDTO.addAll(alReadCheckDAO.getAlReadCheck(session.get("loginUserId").toString()));


		if(alReadDTO.contains(bookList.get((int)session.get("checkNum")).getBookId().toString())){
			alReadCheckMessage = "on";

		}else{
			alReadCheckMessage = "off";
		}

		session.put("alReadCheck", alReadCheckMessage);

		String ret = SUCCESS;
		return ret;
	}



	public List<String> getAlReadDTO() {
		return alReadDTO;
	}



	public void setAlReadDTO(List<String> alReadDTO) {
		this.alReadDTO = alReadDTO;
	}



	public AlReadCheckDAO getAlReadCheckDAO() {
		return alReadCheckDAO;
	}



	public void setAlReadCheckDAO(AlReadCheckDAO alReadCheckDAO) {
		this.alReadCheckDAO = alReadCheckDAO;
	}



	public String getAlReadCheckMessage() {
		return alReadCheckMessage;
	}



	public void setAlReadCheckMessage(String alReadCheckMessage) {
		this.alReadCheckMessage = alReadCheckMessage;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
