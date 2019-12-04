<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<body class="text-center">
<script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>

<form class="form-signin">
<div class="container">
    <c:if test="${userId eq null}">
    	<h1></h1>
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=64d61ee577a64c6d8dde415d657cdff2&redirect_uri=http://localhost:8080/login&response_type=code">
            <img src="/img/kakao_account_login_btn_medium_wide.png">
        </a>
    </c:if>
    <c:if test="${userId ne null}">
        <h1>로그인 성공입니다</h1>
        <input type="button" value="로그아웃" onclick="location.href='/logout'">
    </c:if>
	
    <!-- <h1></h1>
    <p>
    	<button class="btn btn-default" onclick="location.href='/list'">저장목록</button>
    </p> -->
</div>
</form>
</body>
</html>
