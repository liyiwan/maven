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
		function goDeletePerson(id){
			if(window.confirm("ȷ��ɾ����")){
				window.location = "person/person_delete.action?pageNo=${pageInfo.currentPageNo}&id=" + id;
			}
		}
	
	</script>
	
  </head>
  
  <body>
     <table border="1" width="100%">
     	<tr>
     		<td>���</td>
     		<td>�û���</td>
     		<td>������</td>
     		<td align="center">����</td>
     	</tr>
     	<s:iterator value="pageInfo.pageData" var="person" status="status">
	     	<tr>
	     	
	     		<td><s:property value="#status.count"/> </td>
	     		<td>${person.name }</td>
	     		<td>${person.group.name}</td>
	     		<td align="center"><a href="person/person_update?id=${person.id}&type=1">�޸�  </a> 
	     		<a href="javascript:goDeletePerson(${person.id })">ɾ��  </a> <a href="person/person_detailPerson.action?id=${person.id }&type=2">��ϸ</a></td>
	     		
	     	</tr>
     	</s:iterator>
     	<tr></tr>
     </table>
      <div id="page" class="class_information" style="float: right"><p:page pageInfo="${pageInfo}" url="${pageUrl}" params="${pageParams}" /> </div>
  </body>
</html>