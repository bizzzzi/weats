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
		String user_email = (String) session.getAttribute("user_email");
		System.out.println("maliCheckForm.jsp/user_email -> " + user_email);
		String mesg = (String) session.getAttribute("mesg");
		if (mesg != null) {
	%>

	<script type="text/javascript">
	alert("<%=mesg%>");
	</script>


	<%
		}
		session.removeAttribute("mesg");
	%>
	<div id="mailCheckForm">
		<div class="mailCheckTitle">이메일 인증</div>
		<p>
			인증 메일이 <span class="mailCheckFormEmail"><%=user_email%></span> (으)로
			전송되었습니다.
		</p>
		<p>받으신 이메일을 열어 버튼을 클릭하면 가입이 완료됩니다.</p>
		<button onclick="location.href='main.jsp'">확인</button>
	</div>
</body>
</html>