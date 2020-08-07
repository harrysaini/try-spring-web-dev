<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Student form 


<form:form action="processForm" modelAttribute="student">

	First name: <form:input path="name"/> 
	<br>
	<br>
	
	Age: <form:input path="age"/>
	
	
	<br>
	<br>
	
	
	Country: 
	
	<form:select path="country">
	
		<form:options items="${countryOptions}"/>
		
	</form:select>
	
	<br>
	<br>
	
	Favorite Language: <form:radiobuttons path="favoriteLanguage" items="${languageOptions}"/>
	
	<br>
	<br>
	
	Operating Systems: <form:checkboxes items="${osOptions}" path="operatingSystems"/>
	
	<br>
	<br>
	
	<input type="submit" value="submit"/> 

</form:form>

</body>
</html>