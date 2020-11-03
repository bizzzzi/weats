<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	String user_email = (String)session.getAttribute("user_email");
	System.out.println("maliCheckForm.jsp/user_email -> "+ user_email);
	String mesg = (String) session.getAttribute("mesg");
	if(mesg != null) {
%>

<script type="text/javascript">
	alert("<%=mesg%>");
</script>

<% }
	session.removeAttribute("mesg");
%>
<b>입력하신 이메일로 메일을 전송했습니다.</b><br/>
	이메일:	<input type="text" name="user_email" value="<%=user_email%>"><br>
</body>
</html>