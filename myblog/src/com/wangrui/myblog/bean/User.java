package com.wangrui.myblog.bean;

public class User {

	private int userID;
	private String loginName;
	private String pwd;
	private String email;
	private String question;
	private String answer;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User(int userID, String loginName, String pwd, String email, String question, String answer) {
		super();
		this.userID = userID;
		this.loginName = loginName;
		this.pwd = pwd;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", loginName=" + loginName + ", pwd=" + pwd + ", email=" + email
				+ ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}
