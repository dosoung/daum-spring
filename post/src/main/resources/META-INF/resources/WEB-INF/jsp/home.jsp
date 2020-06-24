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

    <!-- 로그인 폼 CSS -->
    <div id="loginer">
        <h1>Main</h1>
        <div id="form">
            <form method="POST" name="login"
                  action="<%=request.getContextPath()%>/login">
                <fieldset>
                    <legend>LOGIN !</legend>
                    이메일: <input type="text" name="id" value="${email}" placeholder="Enter Your Email">
                    <br><br>
                    비밀번호: <input type="password" name="pwd1" value="${password}" placeholder="Enter Your Password">
                    <br><br>
                    <button type="submit"></button>
                    You Don't Have Your Account?<a href="<%=request.getContextPath()%>/register"><p style="color: plum">  Click here!!</p></a>
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
