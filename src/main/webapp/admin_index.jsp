<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员主页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body{
			margin:0 auto;
		}
		.main{
			width:800px;
			height:800px;
			margin-left:25%;
		}
		.top{
			width:100%;
			height:160px;
			background:blue;
			background-image: url("images/woyo.jpg");
		}
		.mainLeft{
			width:200px;
			height:400px;
			background:silver;
			float:left;
			border-bottom-color: red;
			border-bottom-width: 1px;
		}
		.mainRight{
			width:600px;
			height:600px;
			float:left;
			background-color:gray;
		}
		.container{
			width:100%;
			height:100%;
		}
	</style>
	<script type="text/javascript">
		function logout(){
			if(confirm("确认退出?")){
				window.location="admin/admin_logout";
			}
		}
	
	</script>
  </head>
  
  <body>
     <div class="main">
     	<div class="top"></div>
     
     	<div class="mainLeft" align="center">
     		<table cellspacing="20">
     			<tr>
     				<td><a href="person/person_findAll" target="container">用户管理</a></td>
     			</tr>
     			<tr>
     				<td><a href="group/group_findAll" target="container">用户组管理</a></td>
     			</tr>
     			<tr>
     				<td><a href="addmin_update_password.jsp" target="container">密码修改</a></td>
     			</tr>
     			<tr>
     				<td><a href="" onclick="logout()" >退出登陆</a></td>
     			</tr>
     		</table>
     	</div>
     	<div class="mainRight">
     		<iframe name="container" frameborder="0" class="container" scrolling="auto"></iframe>
     	</div>
     </div>
  </body>
</html>
