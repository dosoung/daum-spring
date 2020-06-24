<%@ page language="java" contentType="text/html; charset=kr"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
<c:if test="${not empty message}">
    ${message}
</c:if>
<h3>?? ??</h3>
<form method="POST" name="login"
      action="<%=request.getContextPath()%>/login">

    Email: <input name="email" value="${email}" type="text" />  <br /> <br />
    Password: <input name="password" value="${password}" type="text" />
    <br /> <br />
    <input value="???" type="submit" />
</form>
</body>
</html>
