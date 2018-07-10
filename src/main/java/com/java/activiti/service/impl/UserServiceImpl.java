package com.java.activiti.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.activiti.dao.UserDao;
import com.java.activiti.model.Manager;
import com.java.activiti.model.User;
import com.java.activiti.service.UserService;

@Service("serService")
public class UserServiceImpl implements UserService
{
   
	@Resource
	private UserDao userDao;
	

	public User login(Map<String, Object> map) {
	
		return userDao.login(map);
	}


	public List<Manager> findAll() {
	
		return userDao.findAll();
	}


	public void updateoneuser(Manager manager) 
	{
		
		userDao.updateoneuser(manager);
	}
}
