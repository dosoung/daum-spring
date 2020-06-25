
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <title>Register</title>
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

    <!-- 로그인 폼 CSS -->
    <div id="loginer">
        <h1>회원가입</h1>
        <div id="form">
            <form method="POST" name="register"
                  action="<%=request.getContextPath()%>/add/user">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <fieldset>
                    <legend>Register !</legend>
                    이메일: <input type="text" name="email" value="${email}" placeholder="Enter Your Email this is your ID">
                    <br><br>
                    비밀번호: <input type="password" name="password" value="${password}" placeholder="Enter Your Password">
                    <br><br>
                    비밀번호 확인: <input type="password" name="password2" value="${password2}" placeholder="Enter Your Password Again">
                    <br><br>
                    이름: <input type="text" name="name" value="${name}" placeholder="Enter Your Name">
                    <br><br>
                    전화번호: <input type="text" name="phone" value="${phone}" placeholder="Enter Your PhoneNumber">
                    <br><br>
                    <button type="submit"><p style="color: plum;font-size: large">회원가입</p></button></br>
                    <a href="<%=request.getContextPath()%>/">Go Back!!</a>
                </fieldset>
            </form>
        </div>
    </div>

    <!-- 하단 -->
    <div id="footer">
        <p align="center">&copy; Copyright</p>
    </div>
</div>
</body>
</html>

