<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new user</title>
</head>
<body>
	<h1>Add new user</h1>
	<c:url value="/add-user" var="url" />
	<form:form modelAttribute="user" method="post" action="${url}">
		<p>Username</p>
		<form:input path="name" />
		<form:errors path="name" />
		<p>Password</p>
		<form:password path="password" />
		<form:errors path="password" />
		<form:hidden path="id" />
		<p>Gender</p>
		<form:select path="gender">
			<form:option value="male">male</form:option>
			<form:option value="female">female</form:option>
		</form:select>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>