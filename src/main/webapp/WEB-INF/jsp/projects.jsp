<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Project list</title>
</head>
<body>
<%@ include file="header.jsp" %>
</p>
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="project" items="${projects}" varStatus="status">
			<tr>
				<td>${project.id}</td>
				<td>${project.name}</td>
				<td>${project.description}</td>
				<td><a href="<c:url value='/projects/edit/${project.id}'/>">Edit</a></td>
				<td><a href="<c:url value='/projects/del/${project.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br />
	<a href="<c:url value='/projects/add'/>">Add</a>
	
</body>
</html>