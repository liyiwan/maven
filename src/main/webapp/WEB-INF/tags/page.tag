<%@ tag body-content="empty" import="java.util.* , com.woyo.common.page.PageInfoImpl" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="pageInfo" required="true" rtexprvalue="true" type="com.woyo.common.page.PageInfo"%>
<%@ attribute name="url" required="true" rtexprvalue="true"%>
<%@ attribute name="params" required="false" rtexprvalue="true"%>

<script type="text/javascript">
<!--
var url = "${url}";
var params = "${params}";

function gotoPage(page) {
	var tmp = "";
	if(url.indexOf("?") >= 0) {

		tmp = url + "&pageNo=" + page;
	} else {
		tmp = url + "?pageNo=" + page;
	}
	if(params != null && params.length > 0) {
		tmp = tmp + "&" + params;
	}
//alert("tmp:"+tmp);
	window.location.href = tmp;
}

function stopEvent(evt) {
	if(window.addEventListener) {
		evt.stopPropagation();
		evt.preventDefault();
	} else {
		evt.cancelBubble = true;
		evt.returnValue = false;
	}
}

function changed(evt){
	if(evt.keyCode == 13) {
		var pa = parseInt(document.getElementById('gogogo').value);
		if(pa >= 1 &&pa <= ${pageInfo.pageCount }){
			gotoPage(pa);
			stopEvent(evt);
		}else{
			alert("你输入的跳转页面参数不正确！");
			document.getElementById('gogogo').value = '';
			document.getElementById('gogogo').focus();
			stopEvent(evt);
		}
	}
	return true;
}

function jumpPage() {
		var pa = parseInt(document.getElementById('gogogo').value);
		if(pa >= 1 &&pa <= ${pageInfo.pageCount }){
			gotoPage(pa);
		}else{
			alert("你输入的跳转页面参数不正确！");
			document.getElementById('gogogo').value = '';
			document.getElementById('gogogo').focus();
		}
}
//-->
</script>

 <c:choose>
 	<c:when test="${pageInfo.totalRecords <= 0}">
 		<span class="more_page">无相关分页数据</span>
 	</c:when>
 	
 	<c:when test="${pageInfo.totalRecords > 0}">
 			<span class="more_page">
 			<% 
 				Object obj = this.getJspContext().getAttribute("pageInfo");
 				PageInfoImpl map = (PageInfoImpl)obj;
 				
 				int max = map.getPageCount(); //共有多少页
 				int c = map.getCurrentPageNo();//当前页码
 				
 				int i = 1; //循环起始编号
 				int k = max; //循环结束编号
 				
 				if(max<=10){//每页显示10个
 					
 				}else if(c<=5){
 					k = 10;
 				}else if(c+5>=max){
 					i = max-9;
 				}else{
 					i = c -4;
 					k = c + 5;
 				}
 				
 				
 				for(; i<=k; i++){
 					this.getJspContext().setAttribute("i",i);
 			%>
 				<a href="javascript: gotoPage(<%=i %>)" style="border-color:${pageInfo.currentPageNo == i ? '#FF0000' : ''}"><%= i %></a>
 			<% 
 				}
 			%>
 			</span>
 			<span class="more_page">转到第<input id="gogogo" name="textfield" type="text" value="${pageInfo.currentPageNo}" size="2" onkeypress="changed(event)" />页&nbsp;<a href="javascript:jumpPage()">Go</a>&nbsp;</span>
	 		<span class="more_page">共${pageInfo.pageCount }页${pageInfo.totalRecords }条记录</span>
 	</c:when>
 </c:choose>
