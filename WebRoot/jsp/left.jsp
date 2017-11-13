<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
    <div style="width: 210px;">
    <div style="width:214px;min-height:500px;">
        <div style="width:214px;">
            <div class="sm">
				<dl class="">
                    <dt><a href="https://www.baidu.com">****</s>
                    </a></dt>
                </dl>
                <dl class="">
                    <dt><a href="">我的课程</s>
                    </a></dt>
                </dl>

                <dl>
                    <dt><a href="" >基本信息</a></dt>
                </dl>
            </div>
        </div>
    </div>
</div>
  </body>
</html>
