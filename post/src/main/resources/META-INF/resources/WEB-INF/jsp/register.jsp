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
    <h2>회원가입</h2>
    <form method="POST" name="addUser"
          action="<%=request.getContextPath()%>/add/user">

        이메일 및 아이디: <input name="email" value="${email}" type="text" />  <br /> <br />
        비밀번호 확인: <input name="password" value="${password}" type="text" />
        <br /> <br />
        비밀번호: <input name="password" value="${password}" type="text" />
        <br /> <br />
        이름 : <input name="name" value="${name}" type="text" />
        <br /> <br />
        전화번호: <input name="phone" value="${phone}" type="text" /><br /> <br />

        <input value="완료" type="submit" />
        <input type="button" type="submit" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/home'" />
    </form>
</div>
</body>
</html>
