<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>

<c:if test="${not empty message}">
    ${message}
</c:if>
<c:choose>
    <c:when test="${boards != null}">
        <div class="ADD" style="text-align: center;margin-top:100px">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <h1>${member.name}님 환영합니다. </h1>
        <h3>List of Boards</h3>
            <div class="table" style="margin-left:450px;">
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="t" items="${boards}">
                <tr>
                    <td>${t.id}</td>
                    <td>${t.name}</td>
                    <td>${t.phone}</td>
                    <td>${t.email}</td>
                    <td><a
                            href="<%=request.getContextPath()%>/board/${t.id}">Details</a>
                        &nbsp;<a
                                href="<%=request.getContextPath()%>/update/board/${t.id}">Update</a>
                        &nbsp; <a
                                href="<%=request.getContextPath()%>/delete/board/${t.id}"
                                onclick="return confirm('정말 삭제 하시겠습니까?')">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        <a href="<%=request.getContextPath()%>/addBoard">게시글 추가하기</a>
        </div>
    </c:when>
    <c:otherwise>
        유저 정보가 존재하지 않습니다.
    </c:otherwise>
</c:choose>
</body>
</html>