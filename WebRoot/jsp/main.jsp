<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <head>
    <title>笔记</title>
  </head>
  
  <style type="text/css">
     .topDiv{
     	height: 200px;
     }
     
     .leftDiv{
     	float: left;
     	width: 100px;
     }
     
     .rightDiv{
     	float: left;
     }
  </style>
  
  
  
  <body>
	<h1>欢迎你：${user.name}</h1><br/>
	
	<div class="topDiv" style="border:1px #000000   solid;">
		<jsp:include page="/jsp/top.jsp" ></jsp:include>
	</div>
     
    <div class="leftDiv" style="border:1px #000000   solid;">
		<jsp:include page="/jsp/left.jsp" ></jsp:include>
	</div>
	
	<div class="rightDiv" style="border:1px #000000   solid;">
		<jsp:include page="/jsp/right.jsp" ></jsp:include>
	</div>      
    

	
	
	
	
	
	
  </body>
</html>
