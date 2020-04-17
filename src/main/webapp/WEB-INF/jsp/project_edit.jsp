<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Project edit</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/projects"
		modelAttribute="project">
		<form:hidden path="id"/>
		<p>Name:</p>
		<p>
			<form:input path="name" />
		</p>
		<p>Description:</p>
		<p>
			<form:input path="description" />
		</p>
		<p>Begin:</p>
		<p>
			<form:input type="date" path="dateBegin" />
		</p>
		<p>End:</p>
		<p>
			<form:input type="date" path="dateEnd" />
		</p>
		<p>
			<form:button>OK</form:button>
		</p>
	</form:form>
</body>
</html>