package com.java.activiti.service;

import java.util.List;

import com.java.activiti.model.Material;

public interface MaterialService
{
	//����һ������
	public void insertMaterial(Material material);
	
	//��ѯ�û����е�����
	public List<Material> selectAllMaterial(String user_id);
	
	//��ѯĳһ������
	public Material findbyid(int id);
	
	//����ĳһ��������Ϣ
	public void updateMaterial(Material material);
}
