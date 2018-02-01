package com.internousdev.project1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RegItemConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemCategory;
	private int itemPrice;
	private int itemCount;
	private int itemTotalPrice;
	private String itemSearchWord;

	public Map<String, Object> session;
	private String itemErrorMessage;

	public String execute(){
		String ret = ERROR;

		if(!(itemName == ("")) && !(itemCategory == ("")) && !(itemPrice == 0) && !(itemCount == 0)){
			session.put("itemName", itemName);
			session.put("itemCategory", itemCategory);
			session.put("itemPrice", itemPrice);
			session.put("itemCount", itemCount);

			itemTotalPrice = itemPrice * itemCount;
			session.put("itemTotalPrice", itemTotalPrice);

			session.put("itemSearchWord", itemSearchWord);

			ret = SUCCESS;
		}else{
			setItemErrorMessage("未入力項目があります");
			ret = ERROR;
		}

		return ret;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getItemErrorMessage() {
		return itemErrorMessage;
	}

	public void setItemErrorMessage(String itemErrorMessage) {
		this.itemErrorMessage = itemErrorMessage;
	}



}
