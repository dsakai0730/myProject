package com.internousdev.project1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.AlReadCheckDAO;
import com.internousdev.project1.dao.AlReadDAO;
import com.internousdev.project1.dto.MyReadDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyAlReadAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String bookId;
	private String alreadyRead;
	public Map<String, Object> session;
	public AlReadDAO alReadDAO = new AlReadDAO();
	private List<String> alReadList = new ArrayList<String>();
	private AlReadCheckDAO alReadCheckDAO = new AlReadCheckDAO();
	private List<String> alReadDTO = new ArrayList<String>();
	private String alReadCheckMessage;

	public String execute() throws Exception{

		List<MyReadDTO> bookList = (List<MyReadDTO>) session.get("myReadDTOList");


		alReadDAO.alReadBook(
				session.get("loginUserId").toString(),
				session.get("myCheckId").toString(),
				session.get("myCheckImg").toString(),
				session.get("myCheckTitle").toString(),
				session.get("myCheckAuthor").toString(),
				session.get("myCheckPublishedDate").toString(),
				session.get("myCheckDescription").toString());


		alReadList.add(session.get("checkId").toString());
		session.put("alReadList", alReadList);

		alReadDTO.addAll(alReadCheckDAO.getAlReadCheck(session.get("loginUserId").toString()));

		System.out.println(alReadDTO);


		if(alReadDTO.contains(bookList.get((int)session.get("myCheckNum")).getBookId().toString())){
			alReadCheckMessage = "on";

		}else{
			alReadCheckMessage = "off";
		}

		session.put("alReadCheck", alReadCheckMessage);

		String ret = SUCCESS;
		return ret;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public String getAlreadyRead() {
		return alreadyRead;
	}

	public void setAlreadyRead(String alreadyRead) {
		this.alreadyRead = alreadyRead;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public AlReadDAO getAlReadDAO() {
		return alReadDAO;
	}

	public void setAlReadDAO(AlReadDAO alReadDAO) {
		this.alReadDAO = alReadDAO;
	}

	public List<String> getAlReadList() {
		return alReadList;
	}

	public void setAlReadList(List<String> alReadList) {
		this.alReadList = alReadList;
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

	public String getAlReadCheckMessage() {
		return alReadCheckMessage;
	}

	public void setAlReadCheckMessage(String alReadCheckMessage) {
		this.alReadCheckMessage = alReadCheckMessage;
	}



}
