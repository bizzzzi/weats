<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<div id="passwdChangeContainer">
		<form id="passwdChangeForm" action="#" method="post">
			<div class="logo">로고</div>
			<div class="title">비밀번호 변경</div>
			<div class="comment">변경할 비밀번호를 입력하세요</div>
			<div class="signRow">
				<input type="password" name="user_pw" class="userPasswd"
					placeholder="비밀번호 입력" />
				<div class="buttonWrap">
					<button type="submit">확인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>