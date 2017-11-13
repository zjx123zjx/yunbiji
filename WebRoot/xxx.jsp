<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xxx.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     
    <link rel="stylesheet" href="/js/qa.css">

    <script src="/js/jquery.min.js" type="text/javascript"></script>

    <script src="/js/yy.js" type="text/javascript"></script>


  </head>
  
  <body>
    <div class="top">
<div style="color: red"><span>笔记</span></div>
<div style="color: yellowgreen"><span>笔记本</span></div>
</div>
<div class="left">
    <div class="first">
    <div>一</div><div>二</div>
    </div>
    <div class="second">
    <div>A</div><div>B</div>
    </div>
</div>
<div class="right">
    <div>
        1 <br/>2 <br/>  3 <br/>
    </div>
    <div>
        4<br/>5<br/> 6 <br/>
    </div>
    <div>
        a<br/>b <br/> c <br/>
    </div>
    <div>
        d<br/>e <br/>f<br/>
    </div>
</div>
  </body>
</html>
