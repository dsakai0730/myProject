package com.internousdev.project1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BackFollowersInfoAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public String execute(){
		String ret = SUCCESS;
		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
