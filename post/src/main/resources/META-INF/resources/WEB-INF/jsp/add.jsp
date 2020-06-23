<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
<c:if test="${not empty message}">
    ${message}
</c:if>
<h3>Add User</h3>
<form method="POST" name="add_board"
      action="<%=request.getContextPath()%>/add/board">
    Name: <input name="name" value="${name}" type="text" /> <br /> <br />
    Phone: <input name="phone" value="${phone}" type="text" />  <br /> <br />
    Email: <input name="email" value="${email}" type="text" />
    <br /> <br />
    <input value="Add Board" type="submit" />
</form>
</body>
</html>
