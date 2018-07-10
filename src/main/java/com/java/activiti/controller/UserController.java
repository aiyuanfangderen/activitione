package com.java.activiti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.activiti.model.Manager;
import com.java.activiti.model.User;
import com.java.activiti.service.UserService;
import com.java.activiti.util.ResponseUtil;
import com.java.activiti.util.Result;
import com.java.activiti.util.ResultCode;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")

public class UserController 
{

	@Resource
	private UserService userService;
	
	@RequestMapping("/userLogin")
	public String userLogin(HttpServletResponse response,HttpServletRequest request,String userName,String password) throws Exception
	{
		//
		//传递输入的账号密码
		Map<String,Object> map=new HashMap<String, Object>();
		//Result result=new Result();
		//map.put("userName", request.getParameter("userName"));
		//map.put("password", request.getParameter("password"));
		
		map.put("userName",userName);
		map.put("password",password);
		
		User user=userService.login(map);
		
		if(user==null)
		{
			System.out.println("用户不存在");
		}
		else if(user.getNAME_().equals("业务员"))
		{
			System.out.println("业务员登陆成功");
			 //result.setResultCodeAndData(ResultCode.LOGIN_SUCCESS,user);
			 //return result;
			
		}
		else if(user.getNAME_().equals("副经理"))
		{
			System.out.println("副经理登陆成功");
		}
		else if(user.getNAME_().equals("经理"))
		{
		  System.out.println("经理登陆");	
		}
		
		else
		{
			System.out.println("管理员登陆");
		}
		
		
		
		
		
		//此部分用于转换json格式，返回请求
//		JSONObject result=new JSONObject();
//		if(user==null){
//			result.put("success", false);
//			result.put("errorInfo", "用户名或者密码错误！");
//		}else{
//			result.put("success", true);
//			request.getSession().setAttribute("user", user);
//		}
//		ResponseUtil.write(response, result);
		
		return null;
		

				
	}
	
	

	
}
