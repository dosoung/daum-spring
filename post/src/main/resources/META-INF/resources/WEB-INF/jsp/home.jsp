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

<div class="container">
<h2>어서오세요 게시판 입니다.</h2>
<form method="POST" name="login"
      action="<%=request.getContextPath()%>/login">
    Email: <input name="email" value="${email}" type="text" />  <br /> <br />
    Password: <input name="password" value="${password}" type="text" />
    <br /> <br />
    <input value="로그인" type="submit" />
    <input type="button" value="회원가입" onclick="location.href='<%=request.getContextPath()%>/register'"/>


</form>
</div>
</body>
</html>
