<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
	${requestScope.Context }
	<form action="${pageContext.request.contextPath }/LoginServlet?method=login"
		method="POST">
		用户名：<input type="text" name="username" /><br /><br /> 密码：&nbsp;&nbsp;&nbsp;<input
			type="password" name="password" /><br /> <input type="submit"
			value="登陆" />
	</form>
</body>
</html>