<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String uri = (String)request.getAttribute("uri");
	System.out.println("jsp"+uri);
%>
	<form action="test">
		<input type="text" name="name">
		<input type="submit" value="aaa">
	</form>
</body>
</html>