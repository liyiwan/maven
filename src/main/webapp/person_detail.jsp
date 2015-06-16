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
	<script type="text/javascript">
	
		function goall(){
			window.location="person/person_findAll";
		}
		function goallPersons(){
			window.location="person/person_findAllPersons";
		}
	</script>
  </head>
  
  <body>
     	Name:<input type="text" value=" ${model.name }" readonly="readonly"/><br/>
     	Group:<input type="text" value="${model.group.name }" readonly="readonly"/><br/>
     	<s:if test="type==1">
     		<a href="javascript:void goallPersons()" >·µ»Ø</a>
     	</s:if>
     	<s:if test="type==2">
     		<a href="javascript:void goall()" >·µ»Ø</a>
     	</s:if>
     	
  </body>
</html>
