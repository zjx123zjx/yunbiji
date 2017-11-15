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
  <h1>欢迎你：${user.name}</h1><br/>
  		<center><a href="${pageContext.request.contextPath}/jsp1/create.jsp">创建笔记本</a></center>
   		<form action="" method="POST">
   			<table border="2" align="center">
   			    <th colspan="3">笔记本列表</th>
   				<tr>
   					<th width="20%">姓名</th>
   					<th width="20%">笔记本</th>
   					<th width="60%">操作</th>
   				</tr>
   				
   				<c:forEach items="${notesList}" var="note">  
	                <tr>   
	             		<td align = "center" width="20%">${note.name1}</td>  
	             		<td align = "center">${note.subject1}</td>  
	             		<td align = "center">
	         				<a href="${pageContext.request.contextPath}/emp/findNoteById.action?cxSub=${note.subject1}&cxName=${note.name1}">查询</a>
	         				<a href="${pageContext.request.contextPath}/jsp1/update.jsp?sub=${note.subject1}">修改</a>
	         				<a href="${pageContext.request.contextPath}/emp/del.action?sub=${note.subject1}">删除</a>
	         			</td>  
	         		</tr>
	         		  
				</c:forEach>  
   				
   			</table>
   		</form>
  </body>
</html>
