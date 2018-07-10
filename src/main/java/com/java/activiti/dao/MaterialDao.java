package com.java.activiti.dao;

import java.util.List;

import com.java.activiti.model.Material;

public interface MaterialDao
{
   public void insertMaterial(Material material);
   
   
   public List<Material> selectAllMaterial(String user_id);
   
   
   
   public Material findbyid(int id);
   
   public void updateMaterial(Material material);
}
