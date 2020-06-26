<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <title>LOGIN</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        #loginer
        {
            padding: 20px;
            margin-bottom: 20px;
            border: 1px solid #bcbcbc;
            text-align: center;
        }
        #form
        {
            font-size: 1.3em;
            width: 50%;
            display: inline-block;
        }
        ::placeholder
        {
            font-size: 1.3em;
            font-family: 'Nanum Brush Script', cursive;
        }
        button
        {
            border: 0px;
            background-color: white;
        }



    </style>


    <!-- 링크 색상 없애기 -->
    <style type="text/css">
        a:link { color: black; text-decoration: none;}
        a:visited { color: black; text-decoration: none;}
        a:hover { color: black; text-decoration: underline;}
    </style>

    <!-- 구글 웹 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
    <style>
        body
        {
            font-family: 'Nanum Brush Script', cursive;
        }
    </style>
    <!-- 웹 폰트 끝 -->
</head>


<body>

<div id="container">
<c:if test="${member ==null}">
    <!-- 로그인 폼 CSS -->
    <div id="loginer">
        <h1>Main</h1>
        <c:if test="${not empty message}">
            ${meesage}
        </c:if>
        <div id="form">
            <form method="POST" name="login"
                  action="<%=request.getContextPath()%>/login">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <fieldset>
                    <legend>LOGIN !</legend>
<%--                    name이 requestparam으로 넘어간다. 따라서 name과 controller의 파라미터 이름이 같아야함--%>
                    이메일: <input type="text" name="email" value="${email}" placeholder="Enter Your Email">
                    <br><br>
                    비밀번호: <input type="password" name="password" value="${password}" placeholder="Enter Your Password">
                    <br><br>
                    <button type="submit"><p style="color: plum;font-size: large">로그인</p></button></br>
                    You Don't Have Your Account?<a href="<%=request.getContextPath()%>/register">  Click here!!</a>
                </fieldset>
            </form>
        </div>
    </div>
</c:if>

    <!-- 하단 -->
    <div id="footer">
        <p align="center">&copy; Copyright</p>
    </div>
</div>
</body>
</html>
