package com.java.activiti.model;


/**
 * 登陆检验的pojo
 * @author 陈回
 *
 */
public class User
{
	   private String ID_;//用户id
	   private String PWD_;//用户密码
	   private String NAME_;//角色类型
	
	
   public String getID_() {
		return ID_;
	}
	public void setID_(String iD_) {
		ID_ = iD_;
	}
	public String getNAME_() {
		return NAME_;
	}
	public void setNAME_(String nAME_) {
		NAME_ = nAME_;
	}
  
  public String getPWD_() 
  {
	return PWD_;
  }
  public void setPWD_(String pWD_) 
  {
	PWD_ = pWD_;
  } 
  
}
