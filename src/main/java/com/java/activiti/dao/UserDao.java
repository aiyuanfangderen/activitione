package com.java.activiti.dao;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Manager;
import com.java.activiti.model.User;

public interface UserDao {
	//��½
	public User login(Map<String, Object> map);
	
	//����Ա��ѯ
	public List<Manager> findAll();
	
	//����Ա�޸��û�����
	public void updateoneuser(Manager manager);
	
}
