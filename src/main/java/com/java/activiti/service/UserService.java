package com.java.activiti.service;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Manager;
import com.java.activiti.model.User;

public interface UserService
{
    //��½
	public User login(Map<String, Object> map);
	
	//����Ա��ѯ
	public List<Manager> findAll();
	
	//����һ���û�
	public void updateoneuser(Manager manager);
	
}
