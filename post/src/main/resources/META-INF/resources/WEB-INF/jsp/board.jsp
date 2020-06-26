<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
Id : ${board.id}
<br /> Name : ${board.name}
<br /> Phone : ${board.phone}
<br /> Email : ${board.email}
</body>
</html>
