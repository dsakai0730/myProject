package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;


public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String  loginUserId;
	private String userName;
	private String loginPassword;
	public Map<String, Object> session;
	private String result;
	private String userErrorMessage;

	public String execute(){
		result = SUCCESS;

		if(!(loginUserId.equals("")) && !(userName.equals("")) && !(loginPassword.equals(""))){
			
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();

			String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? ";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, loginUserId);
				ResultSet rs = ps.executeQuery();

				if(rs.next()){
					setUserErrorMessage("既に使われているユーザーIDです");
					result = ERROR;
				}else {
					session.put("loginUserId", loginUserId);
					session.put("userName", userName);
					session.put("loginPassword", loginPassword);
					result = SUCCESS;
				}

			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}else{
			setUserErrorMessage("未入力項目があります");
			result = ERROR;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUserErrorMessage() {
		return userErrorMessage;
	}

	public void setUserErrorMessage(String errorMessage) {
		this.userErrorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
