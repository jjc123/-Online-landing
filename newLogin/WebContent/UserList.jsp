<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线用户显示</title>
</head>
<body>
	<table border="1" width="70%" align="center" cellpadding="6"
		cellspacing="2">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
		</tr>
		<c:choose>
			<c:when test="${not empty applicationScope.users}">
				<c:forEach var="user" items="${applicationScope.users }"
					varStatus="vs">
					<tr>
						<td>${vs.count}</td>
						<td>${user.name}</td>
						<td>${user.password}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3">无在线人员</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>