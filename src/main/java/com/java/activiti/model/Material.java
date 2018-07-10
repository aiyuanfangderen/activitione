package com.java.activiti.model;

public class Material 
{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_data() {
		return user_data;
	}
	public void setUser_data(String user_data) {
		this.user_data = user_data;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private int id;
	private String user_id;
	private String user_data;
	private String state;

}
