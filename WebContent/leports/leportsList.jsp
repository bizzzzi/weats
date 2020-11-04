<%@page import="com.dto.LeportsThumbnailDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
a {
	color: black;
}
div ul li {
	display: inline-block;
}
</style>
</head>
<body>
	<div id="desktop">
		<jsp:include page="/common/header_desktop.jsp" flush="true"></jsp:include>
		<jsp:include page="/common/loginForm_desktop.jsp" flush="true"></jsp:include>
		<jsp:include page="/common/signUpForm_desktop.jsp" flush="true"></jsp:include>
	</div>
	<div id="mobile">
		<jsp:include page="/common/header_mobile.jsp" flush="true"></jsp:include>
		<jsp:include page="/common/navbar_mobile.jsp" flush="true"></jsp:include>
	</div>

	<%
		String category = (String) request.getParameter("category");
		if (category != null) {
			if (category.equals("byType")) {
	%>
	<div>
		<ul>
			<li><a href="LeportsListServlet?category=byType&type=all">전체</a></li>
			<li><a href="LeportsListServlet?category=byType&type=지상">지상</a></li>
			<li><a href="LeportsListServlet?category=byType&type=수상">수상</a></li>
			<li><a href="LeportsListServlet?category=byType&type=항공">항공</a></li>
			<li><a href="LeportsListServlet?category=byType&type=실내">실내</a></li>
		</ul>
	</div>
	<%
			} else {
	%>
	<div>
		<ul>
			<li><a href="LeportsListServlet?category=byLoc&loc=all">전체</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=서울">서울</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=인천">인천</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=경기">경기</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=강원">강원</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=충청">충청</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=경상">경상</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=부산">부산</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=전라">전라</a></li>
			<li><a href="LeportsListServlet?category=byLoc&loc=기타">기타</a></li>
		</ul>
	</div>
	<%
			}
		}
	%>
	<div>
		<select>
			<option>기본순</option>
			<option>가격 높은 순</option>
			<option>가격 낮은 순</option>
			<option>리뷰 순</option>
		</select>
	</div>

	<div>
		<!-- list for문 돌려서 반복 출력 -->
		<%
			List<LeportsThumbnailDTO> list = (List)request.getAttribute("leportsList");
			System.out.println(list.size());
			for(int i=0; i<list.size(); i++) {
				LeportsThumbnailDTO dto = list.get(i);
				String leports_id = dto.getLeports_id();
				String leports_title = dto.getLeports_title();
				String leports_main_img = dto.getLeports_main_img();
				String leports_loc = dto.getLeports_loc();
				String leports_summary = dto.getLeports_summary();
				int leports_price = dto.getLeports_price();
		%>
		<a href="#">
			<div>
				<img src="<%=leports_main_img%>">
			</div>
			<div>
				<ul>
					<li>상품 아이디: <%=leports_id %></li>
					<li>상품 이름: <%=leports_title %></li>
					<li>한줄 설명: <%=leports_summary %></li>
					<li>지역: <%=leports_loc%></li>
					<li>가격: <%=leports_price %></li>
				</ul>
			</div>
		</a>
		<% } %>
	</div>

</body>
</html>