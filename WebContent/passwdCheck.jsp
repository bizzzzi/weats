<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String pageType = (String)request.getAttribute("page"); %>
	
	<form action="passwdCheckServlet?page=<%=pageType%>" method="post">
		비번 입력 : <input type="password" name="user_pw"/>
		<button type="submit">다음</button>
	</form>
</body>
</html>