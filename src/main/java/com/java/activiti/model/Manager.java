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
   private String ID_;//�û�id
   private String FIRST_;//�û���
   private String LAST_;//�û���
   private String NAME_;//����
   private String GROUP_ID_;//��id
@Override
public String toString() {
	return "Manager [ID_=" + ID_ + ", FIRST_=" + FIRST_ + ", LAST_=" + LAST_ + ", NAME_=" + NAME_ + ", GROUP_ID_="
			+ GROUP_ID_ + "]";
}
   
   
   
   
}
