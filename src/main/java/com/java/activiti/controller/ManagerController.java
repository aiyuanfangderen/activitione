package com.java.activiti.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.activiti.model.Manager;
import com.java.activiti.service.UserService;

@Controller
@RequestMapping("/manager")
public class ManagerController 
{

	@Resource
	private UserService userService;
	
	
	//管理员查询所有的用户
	@RequestMapping("/Manager")
	public String Manager(HttpServletResponse response,HttpServletRequest request)
	{
		List<Manager> managers=userService.findAll();
		
		for(Manager manager:managers)
		{
			System.out.println("用户id"+manager.getID_());
			System.out.println("用户姓名"+manager.getFIRST_()+manager.getLAST_());
			System.out.println("组id"+manager.getGROUP_ID_());
			System.out.println("组名"+manager.getGROUP_ID_());
		}
		
		
		
		return null;
	}
	
	//管理员更新某一用户
	@RequestMapping("/Updateuser")
	public String Updateuser(HttpServletResponse response,HttpServletRequest request)
	{
		Manager manager=new Manager();
		manager.setID_("004");
		manager.setGROUP_ID_("a");
		
		userService.updateoneuser(manager);
		
		System.out.println("更新成功");
		
		return null;
	}
	
	
	
	
}
