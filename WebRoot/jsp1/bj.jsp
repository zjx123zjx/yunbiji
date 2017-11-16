<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bjb.jsp' starting page</title>
    
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
  <h1>笔记页面</h1><br/>
  		<center><a href="${pageContext.request.contextPath}/jsp1/createbj.jsp">创建笔记</a></center>
   		<form action="" method="POST">
   			<table border="2" align="center">
   			       <th colspan="2">笔记列表</th>
   				<tr>
   					<th width="20%">名称</th>
   					<th width="80%">操作</th>
   				</tr>
   				
   				<c:forEach items="${bjlist}" var="note">  
	                <tr>   
	             		<td align = "center" width="20%">${note.name1}</td>  
	             		<td align = "center">
	         				<a href="${pageContext.request.contextPath}/bj/cxBj.action?id=${note.id1}">查询</a>
	         				<a href="${pageContext.request.contextPath}/bj/upBj.action?id=${note.id1}">修改</a>
	         				<a href="${pageContext.request.contextPath}/bj/del.action?hidd=${note.id1}">删除</a>
	         			</td>  
	         		</tr>
	         		  
				</c:forEach>  
   				
   			</table>
   		</form>
  </body>
</html>
