<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<div layout:fragment="content">
    <h1>Error Page</h1>
    error code : <span th:text="${code}"></span>
    <br>error msg : <span th:text="${msg}"></span>
    <br>timestamp : <span th:text="${timestamp}"></span>
</div>
</form>
</body>
</html>
