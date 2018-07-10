package com.java.activiti.util;

public enum  ResultCode {

    SUCCESS(0, "����ɹ�"),
    WARN(-1, "�����쳣�����Ժ�����"),
    ERROR(-2, "���������쳣"),
    LOGIN_SUCCESS(1,"��½�ɹ�"),
    LOGIN_FAIL(2,"��½ʧ��"),
    LOGIN_OVERTIME(3,"��½ʧ��");
    

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
    	this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}