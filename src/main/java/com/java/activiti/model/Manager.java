package com.java.activiti.model;

public class Manager
{
   public String getID_() {
		return ID_;
	}
	public void setID_(String iD_) {
		ID_ = iD_;
	}
	public String getFIRST_() {
		return FIRST_;
	}
	public void setFIRST_(String fIRST_) {
		FIRST_ = fIRST_;
	}
	public String getLAST_() {
		return LAST_;
	}
	public void setLAST_(String lAST_) {
		LAST_ = lAST_;
	}
	public String getNAME_() {
		return NAME_;
	}
	public void setNAME_(String nAME_) {
		NAME_ = nAME_;
	}
	public String getGROUP_ID_() {
		return GROUP_ID_;
	}
	public void setGROUP_ID_(String gROUP_ID_) {
		GROUP_ID_ = gROUP_ID_;
	}
   private String ID_;//用户id
   private String FIRST_;//用户性
   private String LAST_;//用户名
   private String NAME_;//组名
   private String GROUP_ID_;//组id
@Override
public String toString() {
	return "Manager [ID_=" + ID_ + ", FIRST_=" + FIRST_ + ", LAST_=" + LAST_ + ", NAME_=" + NAME_ + ", GROUP_ID_="
			+ GROUP_ID_ + "]";
}
   
   
   
   
}
