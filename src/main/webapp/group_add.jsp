<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="p" %>
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
       	<form action="group/group_addAndUpdate" method="post" />
       		<s:if test="id!=null">
       			<input type="hidden" name="id" value="${model.id}"/>
       		</s:if>
       		Name:<input type="text" name="name" value="${model.name }"/><br/>
       		<s:if test="id!=null">
       			<input type="submit" value="修改组"/>
       		</s:if>
       		<s:if test="id==null">
       			<input type="submit" value="添加组"/>
       		</s:if>
       		
       	</form>
  </body>
</html>
