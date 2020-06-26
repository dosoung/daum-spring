<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
<c:if test="${not empty message}">
    ${message}
</c:if>
<h3>게시글 업데이트</h3>
<form method="POST" name="update_board"
      action="<%=request.getContextPath()%>/update/board">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input hidden="hidden" name="id" value="${id}" type="text" />
    Name: <input name="name" value="${board.name}" type="text" /> <br /> <br />
    Phone: <input name="phone" value="${board.phone}" type="text" /> <br /> <br />
    Email: <input name="email" value="${board.email}" type="text" /> <br /> <br />
    <input value="게시글 업데이트" type="submit" />
</form>
</body>
</html>
