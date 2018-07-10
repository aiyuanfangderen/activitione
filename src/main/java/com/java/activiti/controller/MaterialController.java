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
	
	//���ϵı��棬�������Զ����user����
	@RequestMapping("insertMaterial")
	public String insertMaterial(HttpServletResponse response,HttpServletRequest request) throws Exception
	{
		//����д�����ϴ���material��ֱ�ӱ��浽���ݿ�,�������п���ȥ��
		
		Material material=new Material();
		material.setUser_id("001");
		material.setUser_data("�������");
		material.setState("δ�ύ");
		
		materialService.insertMaterial(material);
		System.out.println("����ɹ�");
		
		return null;
	}

	
	//���ϵĲ��ң������û������б�������϶���ѯ����������user��
	@RequestMapping("findMaterial")
	public String findMaterial(HttpServletResponse response,HttpServletRequest request) throws Exception
	{
		//�����û�id����
		
	     List<Material> materials=materialService.selectAllMaterial("001");
	     
	     for(Material material:materials)
	     {
	    	 System.out.println("�û�id"+material.getUser_id());
	    	 System.out.println("�û�����"+material.getUser_id());
	    	 System.out.println("״̬"+material.getState());
	    	 
	     }
	     
	     System.out.println("���ҳɹ�");
		
		return null;
	}
	
	
	//�ύ�������̣�����Ϣ���浽�Զ���user��
	@RequestMapping("Submit")
	public String Submit(HttpServletResponse response,HttpServletRequest request)throws Exception
	{

		// ��������
		ProcessInstance pi=
				runtimeService.startProcessInstanceByKey("activitiProcess"); 
				System.out.println("����ʵ��"+pi.getId());
				System.out.println("���̶���id"+pi.getProcessDefinitionId());
		// ��������ʵ��Id��ѯ����
  	Task task=taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult(); 
		
		System.out.println("����id"+task.getId());
		System.out.println("��������"+task.getName());
		
		 // ��� ѧ����д��ٵ�����		
		taskService.complete(task.getId()); 
		Material material=materialService.findbyid(3);
		//�޸�״̬
		material.setState("�����");
		
		 // �޸���ٵ�״̬
		materialService.updateMaterial(material);
//		JSONObject result=new JSONObject();
//		result.put("success", true);
//		ResponseUtil.write(response, result);
		
		
		
		//����������ʧ��ʱ��ҵ��Ա�����޸����ύ�Ĺ��ܣ����뽫�������̺�������ɷֿ���Ϊ��������
		//���һ��������ݿ�user�����һ������ʵ���ֶΣ�������֤�ڵ���޸ĺ��ÿ���ύ����ͬһ������ʵ��
		
		return null;
	}
	
	
	
	
	//��ѯ��ǰ�˵�������
	//�����û���id���ң���ǰ�˵�����
	@RequestMapping("findtask")
	public String findtask(HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		//��Ҫ�����û���id����
		
	   String candidateUser="002";//���ι�������002
	   List<Task> list=taskService.createTaskQuery()
	      .taskCandidateUser(candidateUser).list();
		
	   for(Task task:list)
	   {
		   System.out.println("����id"+task.getId());
		   System.out.println("��������"+task.getName());
		   System.out.println("���������"+task.getAssignee());
		  
		   
	   }
	   
	   
	   
		return null;
	}
	
	
	
	//�������
	@RequestMapping("checktask")
	public String checktask(HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		//��Ҫ�û�id���û��Ľ�ɫ���ͣ����ϵ�id����˳ɹ�����boolֵ����
		
	    //${msg=='��ͬ��'}
		Map<String,Object> variablesMap=new HashMap<String, Object>();
		Boolean flag=false;//��boolֵ��ֵ����
		String candidateUser="002";//ͨ���û�id���ҵ�ǰ�˵�����
		   List<Task> list=taskService.createTaskQuery()
		      .taskCandidateUser(candidateUser).list();
			
		   String name="������";//����˵�����
		   
		   if(name.equals("������"))
		   {
			   if(flag)//�ж����������
			   {
				   variablesMap.put("msg", "ͨ��");
				  
				   
			   }
			   else 
			   {
				   variablesMap.put("msg", "��ͨ��");
				   Material material=materialService.findbyid(2);//ͨ������id����һ�м�¼
					
					material.setState("��˲�ͨ��");//�޸ļ�¼
					
					 //�ύ�����ݿ�
					materialService.updateMaterial(material);
				   
			   }
				   
			   for(Task task:list)
			   {
				  String taskid=task.getId();
				  taskService.complete(taskid, variablesMap);
				  System.out.println("��˲�ͨ��");
						   
			   }
		   }
		   
		   if(name.equals("����"))
		   {
			   if(flag)//�ж����������
			   {
				   variablesMap.put("msg", "ͨ��");
				   Material material=materialService.findbyid(2);//ͨ������id����һ�м�¼					
					material.setState("���ͨ��");//�޸ļ�¼
				   
			   }
			   else 
			   {
				   variablesMap.put("msg", "��ͨ��");
				   Material material=materialService.findbyid(2);//ͨ������id����һ�м�¼
					
					material.setState("��˲�ͨ��");//�޸ļ�¼
					
					 //�ύ�����ݿ�
					materialService.updateMaterial(material);
				   
			   }
				   
			   for(Task task:list)
			   {
				  String taskid=task.getId();
				  taskService.complete(taskid, variablesMap);
				  System.out.println("��˲�ͨ��");
						   
			   }
		   }
		   
		   
		   
		   
		   
//		   if(flag)//�ж����������
//		   {
//			   variablesMap.put("msg", "ͨ��");
//			  
//			   
//		   }
//		   else 
//		   {
//			   variablesMap.put("msg", "��ͨ��");
//			   Material material=materialService.findbyid(2);//ͨ������id����һ�м�¼
//				
//				material.setState("��˲�ͨ��");//�޸ļ�¼
//				
//				 //�ύ�����ݿ�
//				materialService.updateMaterial(material);
//			   
//		   }
//			   
//		   for(Task task:list)
//		   {
//			  String taskid=task.getId();
//			  taskService.complete(taskid, variablesMap);
//			  System.out.println("��˲�ͨ��");
//					   
//		   }
//			  
			   
		return null;
	}
	
	
	
	
	
}
