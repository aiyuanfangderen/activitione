package com.java.activiti.service;

import java.util.List;

import com.java.activiti.model.Material;

public interface MaterialService
{
	//插入一个资料
	public void insertMaterial(Material material);
	
	//查询用户所有的资料
	public List<Material> selectAllMaterial(String user_id);
	
	//查询某一个资料
	public Material findbyid(int id);
	
	//更新某一个资料信息
	public void updateMaterial(Material material);
}
