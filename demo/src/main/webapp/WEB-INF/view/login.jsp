<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页</title>
</head>
<body>
	<div style="width: 300px;height: 200px;margin: 200px auto">
		<form action="loginHander" method="post">
			<table align="center">
				<tr><td>用户名:<input type="text" name="userName"></td></tr>
				<tr><td>密码:<input type="password" name="userPass"></td></tr>
				<tr><td><input type="submit" value="登陆">
				<input type="Reset" value="取消"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>