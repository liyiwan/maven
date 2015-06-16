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
     	<form action="person/person_update.action" method="post" />
     		<input type="hidden" name="id" value="${model.id }"/>
     		Name:<input type="text" name="name" value="${model.name }"><br/>
     		Group:
     		<select name="model.group.id">
     			<s:iterator value="#groups.pageData" var="g">
     				<option value="${g.id }" <s:if test="#g.name==model.group.name">selected</s:if>>${g.name }</option>
     			</s:iterator>
     		</select>
     		
     		<br/>
     		<input type="submit" value="�ύ"/>
     	</form>
  </body>
</html>
