package com.internousdev.project1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.MyReadDAO;
import com.internousdev.project1.dto.MyReadDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private MyReadDAO myReadDAO = new MyReadDAO();
	private List<MyReadDTO> myReadDTOList = new ArrayList<MyReadDTO>();

	public String execute(){

		myReadDTOList = myReadDAO.getMyRead(session.get("loginUserId").toString());

		session.put("myReadDTOList", myReadDTOList);

		String ret = SUCCESS;
		return ret;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
