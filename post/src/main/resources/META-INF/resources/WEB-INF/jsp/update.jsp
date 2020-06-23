<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
<c:if test="${not empty message}">
    ${meesage}
</c:if>
<h3>Update User</h3>
<form method="POST" name="update_board"
      action="<%=request.getContextPath()%>/update/board">
    <input hidden="hidden" name="id" value="${id}" type="text" />
    Name: <input name="name" value="${board.name}" type="text" /> <br /> <br />
    Phone: <input name="phone" value="${board.phone}" type="text" /> <br /> <br />
    Email: <input name="email" value="${board.email}" type="text" /> <br /> <br />
    <input value="Update User" type="submit" />
</form>
</body>
</html>
