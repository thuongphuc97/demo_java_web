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
	<form:form modelAttribute="user" method="post" action="">
		<form:input path="name"/>
		<button type="submit">OK</button>
	</form:form>
</body>
</html>