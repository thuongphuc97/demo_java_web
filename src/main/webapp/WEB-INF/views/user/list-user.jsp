<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All User</title>
</head>
<body>
	<h1>USER LIST</h1>
	
		<table>
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>Password</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${users}" var = "user">
				<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.password}</td>
				<td>${user.gender}</td>
				<td><a href='<c:url value ="/user/user-detail/${user.id}"/>'>Detail</a> - <a href='<c:url value ="/user/delete-user/${user.id}"/>'>Delete</a> - Edit</td>
			</tr>
			</c:forEach>
		</table>

	
</body>
</html>