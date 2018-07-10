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
     
	//ע��activitiService����
	@Resource
	private RepositoryService repositoryService;
	
	/**
	 * ���ϴ����̲���ZIP�ļ�
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addDeploy")
	public String addDeploy(HttpServletResponse response) throws Exception{
		
		//��Ϊֻ��һ�����ӣ�ֱ�ӻ�ȡ���������ļ�
		Deployment deployment=repositoryService.createDeployment() //��������
		.name("myactiviti")	//��Ҫ������������
		.addClasspathResource("activiti/activitiEmployeeProcess.bpmn")//��classpath�м����ļ�
		.addClasspathResource("activiti/activitiEmployeeProcess.png")//��calsspath�м����ļ�
		.deploy();//��ɲ���
		
		
		

		return null;
	}
	
	
	//ɾ�����̶���
		@RequestMapping("deledeProcessDefinition")
		public String deledeProcessDefinition(HttpServletResponse response,HttpServletRequest request)throws Exception
		{
		  
			String deployment="52501";//�������̲���idɾ������
			
			
			repositoryService.deleteDeployment(deployment, true);
			System.out.println("ɾ���ɹ�");
			
			return null;
		}

	
}
