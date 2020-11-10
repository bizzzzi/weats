<%@page import="java.util.List"%>
<%@page import="com.dto.LeportsDetailDTO"%>
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
	List<LeportsDetailDTO> lList = (List) request.getAttribute("leportsDetail");
	//상세 페이지에 공통으로 들어가는 부분 
	LeportsDetailDTO lDTO = lList.get(0); 
	String leports_title = lDTO.getLeports_title();
	String main_img = lDTO.getLeports_main_img();
	String sub_img1 = lDTO.getLeports_sub_img1();
	String sub_img2 = lDTO.getLeports_sub_img2();
	String sub_img3 = lDTO.getLeports_sub_img3();
	String sub_img4 = lDTO.getLeports_sub_img4();
	String content = lDTO.getLeports_content();
	String regidate = lDTO.getLeports_regidate();
	
%>
	<div>
		<div>
			<b><%=leports_title %></b>
			<div>
				<img src="<%=main_img%>">메인 사진
			</div>
			<div>
				<img src="<%=sub_img1%>">서브 1 <img src="<%=sub_img2%>">서브 2 
				<img src="<%=sub_img3%>">서브 3 <img src="<%=sub_img4%>">서브 4
			</div>
			<div>
				<b>달력 자리</b>
			</div>
			<div>
				<div>오늘 날짜</div>
				<!-- for문 돌려서 반복 출력 -->
				<%
					for(int i=0; i<lList.size(); i++) {
						LeportsDetailDTO dto = lList.get(i);
						String max_capacity = dto.getLeports_max_capacity();
						String item_title = dto.getLeports_item_title();
						String summary = dto.getLeports_summary();
						String price = dto.getLeports_price();
				%>
				<div>
					<ul>
						<li>예약 가능 인원 : <%=max_capacity %></li>
						<li>아이템 이름 : <%=item_title %></li>
						<li>아이템 설명 : <%=summary %></li>
						<li>1명 <b><%=price %></b></li>
					</ul>
					<div>
						<button class="js_dwBtn" onclick="pCountFn(<%=i%>,-1, 0);"><img src="#">마이너스 버튼</button>
						<input id="js_pCount<%=i%>" type="text" name="personnelConut" value="1" readonly>
						<button class="js_upBtn" onclick="pCountFn(<%=i%>,1, <%=max_capacity %>);"><img src="#">플러스 버튼</button>
					</div>
				</div>
				<% } %>
				<!-- 여기 까지 -->
				
				<!-- 상품 선택 안했을 땐 없어야되고 선택하면 상품 복수로 선택한 만큼 나와야하는데 어떻게 해야할 지 모르겠음 -->
				<div>
					<div>아이템 이름</div>
					<div>
						<div>인원 수  X 가격</div>
						<div>합계</div>
					</div>
				</div>
				<!-- 여기 까지 -->
				<div>총 금액</div>
			</div>
			<div>
				<button>결제하기 버튼</button>
			</div>
			<div>상품 상세 설명(사진 가능) : <%=content %></div>
			<div>
				<b>후기</b>
				<div>
                    <div>후기 내용띠</div>
                    <button>후기 전체보기</button>
                    
				</div>
			</div>
		</div>
		레포츠 등록 일자 : <%=regidate %>
		<div>
			<button>티켓 선택</button>
			<div>총 금액</div>
		</div>
	</div>
</body>
</html>