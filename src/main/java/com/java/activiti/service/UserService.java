package com.java.activiti.service;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Manager;
import com.java.activiti.model.User;

public interface UserService
{
    //登陆
	public User login(Map<String, Object> map);
	
	//管理员查询
	public List<Manager> findAll();
	
	//更新一个用户
	public void updateoneuser(Manager manager);
	
}
