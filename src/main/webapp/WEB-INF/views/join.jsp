<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

// 파일 미리보기
$(document).ready(function(){
	$("#profile").on("change", handleImgFileSelect);
})
function handleImgFileSelect(e){
	var files = e.target.files;
	var reader = new FileReader();
	reader.onload = function(e){
		$("#img").attr("src", e.target.result);
		$("#img").css("display", "block");			
	}
	reader.readAsDataURL(files[0]);
}

//제출 버튼 : 파일, 이메일, 비밀번호, 닉네임 전송
$(function(){
	$("#btn_join").click(function(e){
	
		var email = $("#email").val();
		var password = $("#pw").val();
		var nickName = $("#nickName").val();
		
		if(email == ""){
			alert("이메일 입력하세요.");
			$("#email").focus();
			return false;
		}
		if(password == ""){
			alert("비밀번호 입력하세요.");
			$("#password").focus();
			return false;
		}
		if(nickName == ""){
			alert("닉네임 입력하세요.");
			$("#nickName").focus();
			return false;
		}
		
		// 폼 데이터를 명시적으로 설정
		var formData = new FormData();
		formData.append("email", email);
		formData.append("password", password);
		formData.append("nickName", nickName);
		formData.append("file", $("#profile")[0].files[0]); // 파일 처리

		$.ajax({
			type: "POST",
			url: "/join",
			data: formData,
			processData: false, // 필수: 데이터를 쿼리 스트링으로 처리하지 않도록 설정
			contentType: false, // 필수: 파일 업로드를 위해 multipart/form-data로 설정
			success: function(){
				alert("저장 완료");
			},
			error: function(){
				alert("오류발생");
			}
		})
	})
})
</script>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar.jsp"/>
	<div>
		<h1>회원가입</h1>
		<form id="join" enctype="multipart/form-data" method="post" action="/join">
			<div>
				<img id="img" style="height:200px; width:200px; display:none;">
				<input type="file" accept="image/*" id="profile" name="profile">
			</div>
		    <div>
		        이메일 <input type="email" id="email" name="email">
		        <button type="button">중복확인</button>
		    </div>
		    <div>
		        비밀번호 <input type="password" id="pw" name="password">
		    </div>
		    <div>
		        비밀번호 확인 <input type="password" id="pwCheck">
		    </div>
		    <div>
		        닉네임 <input type="text" id="nickName" name="nickName">
		        <button type="button">중복확인</button>
		    </div>
		    <div>
		        <button type="button" id="btn_join">가입</button>
		    </div>
		</form>
	</div>
</body>
</html>