<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="css/style.css" rel="stylesheet">
	<script type="text/javascript" src="js/myscript.js"></script>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
<div class = "container">
<h1><c:out value = "${person.firstName}" ></c:out> <c:out value = "${person.lastName}" ></c:out></h1>
<h3>License Number: <c:out value = "${license.number}"></c:out></h3>
<h3>State: <c:out value = "${license.state}"></c:out></h3>
<h3>Expiration Date: <c:out value = "${license.expirationDate}"></c:out></h3>
</div>

</body>
</html>