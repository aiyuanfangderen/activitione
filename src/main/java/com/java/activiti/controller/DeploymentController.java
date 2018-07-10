package com.java.activiti.controller;

import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/deploy")
public class DeploymentController
{
     
	//注入activitiService服务
	@Resource
	private RepositoryService repositoryService;
	
	/**
	 * 添上传流程部署ZIP文件
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addDeploy")
	public String addDeploy(HttpServletResponse response) throws Exception{
		
		//因为只是一个例子，直接获取两个加载文件
		Deployment deployment=repositoryService.createDeployment() //创建部署
		.name("myactiviti")	//需要部署流程名称
		.addClasspathResource("activiti/activitiEmployeeProcess.bpmn")//从classpath中加载文件
		.addClasspathResource("activiti/activitiEmployeeProcess.png")//从calsspath中加载文件
		.deploy();//完成部署
		
		
		

		return null;
	}
	
	
	//删除流程定义
		@RequestMapping("deledeProcessDefinition")
		public String deledeProcessDefinition(HttpServletResponse response,HttpServletRequest request)throws Exception
		{
		  
			String deployment="52501";//根据流程部署id删除流程
			
			
			repositoryService.deleteDeployment(deployment, true);
			System.out.println("删除成功");
			
			return null;
		}

	
}
