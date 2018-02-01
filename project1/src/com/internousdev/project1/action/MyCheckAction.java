package com.internousdev.project1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.AlReadCheckDAO;
import com.internousdev.project1.dto.MyReadDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyCheckAction extends ActionSupport implements SessionAware {

	private String bookId;
	public Map<String, Object> session;
	private int myCheckNum;
	private AlReadCheckDAO alReadCheckDAO = new AlReadCheckDAO();
	private List<String> alReadDTO = new ArrayList<String>();
	private String alReadCheckMessage;

	public String execute(){
		String ret = SUCCESS;

		// List<DTO>をキャスト(=変換)する方法です。
		List<MyReadDTO> bookList = (List<MyReadDTO>) session.get("myReadDTOList");


		session.put("myCheckNum", myCheckNum);
		session.put("myCheck", bookList.get(myCheckNum));
		session.put("myCheckId", bookList.get(myCheckNum).getBookId());
		session.put("myCheckImg", bookList.get(myCheckNum).getImg());
		session.put("myCheckTitle", bookList.get(myCheckNum).getTitle());
		session.put("myCheckAuthor", String.join(" ", bookList.get(myCheckNum).getAuthor()));
		session.put("myCheckPublishedDate", bookList.get(myCheckNum).getPublishedDate());
		session.put("myCheckDescription", bookList.get(myCheckNum).getDescription());

		System.out.println(session.get("myCheckId").toString());
		System.out.println(session.get("myCheckImg").toString());
		System.out.println(session.get("myCheckTitle").toString());
		System.out.println(session.get("myCheckAuthor").toString());
		System.out.println(session.get("myCheckPublishedDate").toString());
		System.out.println(session.get("myCheckDescription").toString());

		alReadDTO.addAll(alReadCheckDAO.getAlReadCheck(session.get("loginUserId").toString()));


		if(alReadDTO.contains(bookList.get((int)session.get("myCheckNum")).getBookId().toString())){
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

	public int getMyCheckNum() {
		return myCheckNum;
	}

	public void setMyCheckNum(int myCheckNum) {
		this.myCheckNum = myCheckNum;
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
