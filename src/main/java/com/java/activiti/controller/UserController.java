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
		//����������˺�����
		Map<String,Object> map=new HashMap<String, Object>();
		//Result result=new Result();
		//map.put("userName", request.getParameter("userName"));
		//map.put("password", request.getParameter("password"));
		
		map.put("userName",userName);
		map.put("password",password);
		
		User user=userService.login(map);
		
		if(user==null)
		{
			System.out.println("�û�������");
		}
		else if(user.getNAME_().equals("ҵ��Ա"))
		{
			System.out.println("ҵ��Ա��½�ɹ�");
			 //result.setResultCodeAndData(ResultCode.LOGIN_SUCCESS,user);
			 //return result;
			
		}
		else if(user.getNAME_().equals("������"))
		{
			System.out.println("�������½�ɹ�");
		}
		else if(user.getNAME_().equals("����"))
		{
		  System.out.println("�����½");	
		}
		
		else
		{
			System.out.println("����Ա��½");
		}
		
		
		
		
		
		//�˲�������ת��json��ʽ����������
//		JSONObject result=new JSONObject();
//		if(user==null){
//			result.put("success", false);
//			result.put("errorInfo", "�û��������������");
//		}else{
//			result.put("success", true);
//			request.getSession().setAttribute("user", user);
//		}
//		ResponseUtil.write(response, result);
		
		return null;
		

				
	}
	
	

	
}
