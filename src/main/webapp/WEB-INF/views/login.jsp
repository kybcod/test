<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar.jsp"/>
<h1>로그인</h1>
<form name="login" method="post" action="login">
	<div>
		이메일 <input type="email" name="email">
	</div>
	<div>
		비밀번호 <input type="password" name="password">		
	</div>
	<div>
		<button type="submit">로그인</button>
	</div>
</form>
<a href="/join">회원가입</a>
</body>
</html>