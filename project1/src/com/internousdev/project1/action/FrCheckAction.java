package com.internousdev.project1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.AlReadCheckDAO;
import com.internousdev.project1.dto.FriendReadDTO;
import com.opensymphony.xwork2.ActionSupport;

public class FrCheckAction extends ActionSupport implements SessionAware {

	private String bookId;
	public Map<String, Object> session;
	private int frCheckNum;
	private AlReadCheckDAO alReadCheckDAO = new AlReadCheckDAO();
	private List<String> alReadDTO = new ArrayList<String>();
	private String alReadCheckMessage;

	public String execute(){
		String ret = SUCCESS;

		// List<DTO>をキャスト(=変換)する方法です。
		List<FriendReadDTO> bookList = (List<FriendReadDTO>) session.get("friendReadDTOList");


		session.put("frCheckNum", frCheckNum);
		session.put("frCheck", bookList.get(frCheckNum));
		session.put("frCheckId", bookList.get(frCheckNum).getBookId());
		session.put("frCheckImg", bookList.get(frCheckNum).getImg());
		session.put("frCheckTitle", bookList.get(frCheckNum).getTitle());
		session.put("frCheckAuthor", String.join(" ", bookList.get(frCheckNum).getAuthor()));
		session.put("frCheckPublishedDate", bookList.get(frCheckNum).getPublishedDate());
		session.put("frCheckDescription", bookList.get(frCheckNum).getDescription());

		alReadDTO.addAll(alReadCheckDAO.getAlReadCheck(session.get("loginUserId").toString()));


		if(alReadDTO.contains(bookList.get((int)session.get("frCheckNum")).getBookId().toString())){
			alReadCheckMessage = "on";

		}else{
			alReadCheckMessage = "off";
		}

		session.put("alReadCheck", alReadCheckMessage);


		return ret;
	}



	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	public int getFrCheckNum() {
		return frCheckNum;
	}



	public void setFrCheckNum(int frCheckNum) {
		this.frCheckNum = frCheckNum;
	}



	public AlReadCheckDAO getAlReadCheckDAO() {
		return alReadCheckDAO;
	}



	public void setAlReadCheckDAO(AlReadCheckDAO alReadCheckDAO) {
		this.alReadCheckDAO = alReadCheckDAO;
	}



	public List<String> getAlReadDTO() {
		return alReadDTO;
	}



	public void setAlReadDTO(List<String> alReadDTO) {
		this.alReadDTO = alReadDTO;
	}





}
