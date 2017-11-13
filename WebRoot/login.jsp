<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
  </head>
  <body>
  ${error}
	<form action="${pageContext.request.contextPath}/emp/login.action" method="POST">
		<table border="2" align="center">
			<tr>
				<th>用户名</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="text" name="password"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登录"/>
				</td>
			</tr>
		</table>
	</form>		
  </body>
</html>
