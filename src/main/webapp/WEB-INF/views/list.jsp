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
<div>
	<h1>회원목록</h1>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>프로필 사진</th>
				<th>이메일</th>
				<th>닉네임</th>
				<th>가입일자</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${memberList}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.profile}</td>
				<td>${member.email }</td>
				<td>${member.nickName}</td>
				<td>${member.inserted}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<div>
</body>
</html>