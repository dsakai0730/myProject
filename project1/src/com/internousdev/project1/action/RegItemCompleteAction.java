package com.internousdev.project1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.RegItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegItemCompleteAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String itemCategory;
	private String itemName;
	private int itemPrice;
	private int itemCount;
	private int itemTotalPrice;
	private String itemSearchWord;
	private String result;

	public Map<String, Object> session;
	public RegItemCompleteDAO regItemCompleteDAO = new RegItemCompleteDAO();

	public String execute() throws Exception{

		regItemCompleteDAO.regItem(session.get("loginUserId").toString(), session.get("itemCategory").toString(), session.get("itemName").toString(), (int)(session.get("itemPrice")), (int)(session.get("itemCount")),(int)(session.get("itemTotalPrice")), session.get("itemSearchWord").toString());

		System.out.println(session.get("itemSearchWord"));
		result = SUCCESS;
		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(int itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	public String getItemSearchWord() {
		return itemSearchWord;
	}

	public void setItemSearchWord(String itemSearchWord) {
		this.itemSearchWord = itemSearchWord;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}