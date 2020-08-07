<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Confirm</h1>

${student.name } - ${student.age } - ${student.country } - ${student.favoriteLanguage }

<br>
<br>

OS:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems }">
		<li>${temp }</li>
	</c:forEach>
</ul>

</body>
</html>