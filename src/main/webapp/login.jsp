<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

      <form id="itemForm" action="${pageContext.request.contextPath }/user/userLogin.action" method="post">
   输入账号：
  <input type="text" name="userName"/><br><br>
  输入密码：
  <input type="text" name="password"/><br><br>
  <input type="submit" value="登陆"/>
 </form> 



   <a href="${pageContext.request.contextPath }/manager/Manager.action">管理员查找所有人</a>
   <a href="${pageContext.request.contextPath }/manager/Updateuser.action">更新某一用户</a>
   <a href="${pageContext.request.contextPath }/deploy/addDeploy.action">部署流程</a>
   <a href="${pageContext.request.contextPath }/material/insertMaterial.action">资料提交</a>
   <a href="${pageContext.request.contextPath }/material/findMaterial.action">查找所有资料</a>
   <a href="${pageContext.request.contextPath }/material/Submit.action">提交任务</a>
   <a href="${pageContext.request.contextPath }/material/findtask.action">查找任务</a>
   <a href="${pageContext.request.contextPath }/material/checktask.action">审核任务</a>
   <a href="${pageContext.request.contextPath }/deploy/deledeProcessDefinition.action">删除流程定义</a>
   
   
   
</body>
</html>