package com.java.activiti.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.activiti.dao.MaterialDao;
import com.java.activiti.dao.UserDao;
import com.java.activiti.model.Material;
import com.java.activiti.service.MaterialService;


@Service("materialService")
public class MaterialServicelmpl implements MaterialService
{
	@Resource
	private MaterialDao materialDao;

	public void insertMaterial(Material material)
	{
		materialDao.insertMaterial(material);
		
	}

	public List<Material> selectAllMaterial(String user_id) {
		
		return materialDao.selectAllMaterial(user_id);
	}

	public Material findbyid(int id) {
		
		return materialDao.findbyid(id);
	}

	public void updateMaterial(Material material) 
	{
		materialDao.updateMaterial(material);
		
	}

}
