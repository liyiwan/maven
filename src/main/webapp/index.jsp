<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <center><s:property value="message"/></center>
      <form action="person/person_login" method="post">
    	Name:<input type="text" name="name"/><br/>
    	Pass:<input type="password" name="password" /><br/>
    	<input type="radio" value="1" name="type" />一般用户 <input type="radio" value="2" name="type" checked="checked"/>管理员
    	<br/>
    	<input type="submit" value="提交"/>
    	
    </form>
  </body>
</html>
