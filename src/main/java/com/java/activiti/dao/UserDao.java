package com.java.activiti.dao;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Manager;
import com.java.activiti.model.User;

public interface UserDao {
	//登陆
	public User login(Map<String, Object> map);
	
	//管理员查询
	public List<Manager> findAll();
	
	//管理员修改用户类型
	public void updateoneuser(Manager manager);
	
}
