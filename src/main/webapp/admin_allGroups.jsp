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
    
    <title>�����û�</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="css/index.css" />
	<script type="text/javascript">
		function goDeleteGroup(id){
			if(window.confirm("ȷ��ɾ����")){
				window.location = "group/group_delete.action?pageNo=${pageInfo.currentPageNo}&id=" + id;
			}
		}
	
	</script>
	
  </head>
  
  <body>
     <table border="1" width="100%">
     	<tr>
     		<td>���</td>
     		<td>����</td>
     		<td align="center">����</td>
     	</tr>
     	<s:iterator value="pageInfo.pageData" var="group" status="status">
	     	<tr>
	     	
	     		<td><s:property value="#status.count"/> </td>
	     		<td>${group.name}</td>
	     		<td align="center">
		     		<a href="group/group_goUpdate?id=${group.id}">�޸�  </a> 
		     		<a href="javascript:goDeleteGroup(${group.id })">ɾ��  </a> 
		     		<a href="javascript:void alert('������${group.name }');">��ϸ</a>
		     	</td>
		     		
	     	</tr>
     	</s:iterator>
     	<tr></tr>
     </table><a href="group_add.jsp">�����  </a> 
      <div id="page" class="class_information" style="float: right"><p:page pageInfo="${pageInfo}" url="${pageUrl}" params="${pageParams}" /> </div>
  </body>
</html>
