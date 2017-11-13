<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
  <div style="height: 100%">
    <div style="float: left;width: 33%;background-color: gray; border: 1">
    	<span id="zy"><center>主页</center></span>
    </div>
    
    <div style="float: left;width: 33%;background-color: gray; border: 1">
    	<span id="bj" ><center>笔记</center></span>
    </div>
    
    <div style="float: left;width: 33%;background-color: gray; border: 1">
    	<span id="bjb"><center>笔记本</center></span>
    </div>
  </div>
  </body>
  
</html>
