package com.java.activiti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.activiti.model.Material;
import com.java.activiti.service.MaterialService;
import com.java.activiti.service.UserService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/material")
public class MaterialController
{
	@Resource
	private MaterialService materialService;
	
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	
	//资料的保存，保存在自定义的user表中
	@RequestMapping("insertMaterial")
	public String insertMaterial(HttpServletResponse response,HttpServletRequest request) throws Exception
	{
		//将填写的资料传给material，直接保存到数据库,下面四行可以去掉
		
		Material material=new Material();
		material.setUser_id("001");
		material.setUser_data("请假三天");
		material.setState("未提交");
		
		materialService.insertMaterial(material);
		System.out.println("保存成功");
		
		return null;
	}

	
	//资料的查找，将该用户的所有保存的资料都查询出来，查找user表
	@RequestMapping("findMaterial")
	public String findMaterial(HttpServletResponse response,HttpServletRequest request) throws Exception
	{
		//传递用户id数据
		
	     List<Material> materials=materialService.selectAllMaterial("001");
	     
	     for(Material material:materials)
	     {
	    	 System.out.println("用户id"+material.getUser_id());
	    	 System.out.println("用户资料"+material.getUser_id());
	    	 System.out.println("状态"+material.getState());
	    	 
	     }
	     
	     System.out.println("查找成功");
		
		return null;
	}
	
	
	//提交资料流程，将信息保存到自定义user表
	@RequestMapping("Submit")
	public String Submit(HttpServletResponse response,HttpServletRequest request)throws Exception
	{

		// 启动流程
		ProcessInstance pi=
				runtimeService.startProcessInstanceByKey("activitiProcess"); 
				System.out.println("流程实例"+pi.getId());
				System.out.println("流程定义id"+pi.getProcessDefinitionId());
		// 根据流程实例Id查询任务
  	Task task=taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult(); 
		
		System.out.println("任务id"+task.getId());
		System.out.println("任务名称"+task.getName());
		
		 // 完成 学生填写请假单任务		
		taskService.complete(task.getId()); 
		Material material=materialService.findbyid(3);
		//修改状态
		material.setState("审核中");
		
		 // 修改请假单状态
		materialService.updateMaterial(material);
//		JSONObject result=new JSONObject();
//		result.put("success", true);
//		ResponseUtil.write(response, result);
		
		
		
		//如果想在审核失败时，业务员重新修改再提交的功能，必须将启动流程和任务完成分开作为两个函数
		//而且还得再数据库user里面加一个流程实例字段，这样保证在点击修改后的每次提交，是同一个流程实例
		
		return null;
	}
	
	
	
	
	//查询当前人的组任务
	//根据用户的id查找，当前人的任务
	@RequestMapping("findtask")
	public String findtask(HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		//需要传递用户的id数据
		
	   String candidateUser="002";//传参过来代替002
	   List<Task> list=taskService.createTaskQuery()
	      .taskCandidateUser(candidateUser).list();
		
	   for(Task task:list)
	   {
		   System.out.println("任务id"+task.getId());
		   System.out.println("任务名称"+task.getName());
		   System.out.println("任务办理人"+task.getAssignee());
		  
		   
	   }
	   
	   
	   
		return null;
	}
	
	
	
	//审核任务
	@RequestMapping("checktask")
	public String checktask(HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		//需要用户id，用户的角色类型，资料的id，审核成功与否的bool值数据
		
	    //${msg=='不同意'}
		Map<String,Object> variablesMap=new HashMap<String, Object>();
		Boolean flag=false;//将bool值赋值过来
		String candidateUser="002";//通过用户id查找当前人的任务
		   List<Task> list=taskService.createTaskQuery()
		      .taskCandidateUser(candidateUser).list();
			
		   String name="副经理";//审核人的类型
		   
		   if(name.equals("副经理"))
		   {
			   if(flag)//判断任务的流向
			   {
				   variablesMap.put("msg", "通过");
				  
				   
			   }
			   else 
			   {
				   variablesMap.put("msg", "不通过");
				   Material material=materialService.findbyid(2);//通过资料id查找一行记录
					
					material.setState("审核不通过");//修改记录
					
					 //提交到数据库
					materialService.updateMaterial(material);
				   
			   }
				   
			   for(Task task:list)
			   {
				  String taskid=task.getId();
				  taskService.complete(taskid, variablesMap);
				  System.out.println("审核不通过");
						   
			   }
		   }
		   
		   if(name.equals("经理"))
		   {
			   if(flag)//判断任务的流向
			   {
				   variablesMap.put("msg", "通过");
				   Material material=materialService.findbyid(2);//通过资料id查找一行记录					
					material.setState("审核通过");//修改记录
				   
			   }
			   else 
			   {
				   variablesMap.put("msg", "不通过");
				   Material material=materialService.findbyid(2);//通过资料id查找一行记录
					
					material.setState("审核不通过");//修改记录
					
					 //提交到数据库
					materialService.updateMaterial(material);
				   
			   }
				   
			   for(Task task:list)
			   {
				  String taskid=task.getId();
				  taskService.complete(taskid, variablesMap);
				  System.out.println("审核不通过");
						   
			   }
		   }
		   
		   
		   
		   
		   
//		   if(flag)//判断任务的流向
//		   {
//			   variablesMap.put("msg", "通过");
//			  
//			   
//		   }
//		   else 
//		   {
//			   variablesMap.put("msg", "不通过");
//			   Material material=materialService.findbyid(2);//通过资料id查找一行记录
//				
//				material.setState("审核不通过");//修改记录
//				
//				 //提交到数据库
//				materialService.updateMaterial(material);
//			   
//		   }
//			   
//		   for(Task task:list)
//		   {
//			  String taskid=task.getId();
//			  taskService.complete(taskid, variablesMap);
//			  System.out.println("审核不通过");
//					   
//		   }
//			  
			   
		return null;
	}
	
	
	
	
	
}
