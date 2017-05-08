package com.dfrz.bean;

public class TUser {
	private int id;
	private String login_name;
	private String login_password;
	private String real_name;
	private String mobile;
	private String create_time;
	private String login_time;
	private int count;
	public TUser() {
		super();
	}
	public TUser(int id, String login_name, String login_password,
			String real_name, String mobile) {
		super();
		this.id = id;
		this.login_name = login_name;
		this.login_password = login_password;
		this.real_name = real_name;
		this.mobile = mobile;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	


}
