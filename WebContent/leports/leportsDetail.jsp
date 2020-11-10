<%@page import="com.dto.LeportsReviewDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.LeportsDetailDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

					<div class="list_item">
						<input class="js_itemName" type="text" value="<%=item_title%>" style="display:none">
						<input class="js_maxPerson" type="text" value="<%=max_capacity%>" style="display:none">
						<input class="js_itemPrice" type="text" value="<%=price%>" style="display:none">
						<button class="js_dwBtn"><img src="#">마이너스 버튼</button>
						<input class="js_pCount" type="text" name="personnelConut" value="0" readonly>
						<button class="js_upBtn"><img src="#">플러스 버튼</button>

					</div>
				</div>
				<% } %>
				<!-- 여기 까지 -->
				
				<!-- 상품 선택 안했을 땐 없어야되고 선택하면 상품 복수로 선택한 만큼 나와야하는데 어떻게 해야할 지 모르겠음 -->
				<div class="select_item_list">
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
					<div class="js_selectItem"></div>
				</div>
				<!-- 여기 까지 -->
				<div class="js_total_amount"></div>
			</div>
			<div>
				<button>결제하기 버튼</button>
			</div>
			<div>상품 상세 설명(사진 가능) : <%=content %></div>
			<div>
				<b>후기</b>
				<% List<LeportsReviewDTO> rList = (List) request.getAttribute("leportsReview");
				   
				   for(int i=0; i<rList.size();i++) {
					   LeportsReviewDTO rDTO = rList.get(i);
					   String user_name = rDTO.getUser_name();
					   String review_comments = rDTO.getReview_comments();
					   String review_regidate = rDTO.getReview_regidate();
					   
				%>	
				
                    <div style='border:1px solid black; width:300px'>
                    	<div><%=user_name %></div>
                    	<div><%=review_comments %></div>
                    	<div><%=review_regidate %></div>
                    </div>
				<%    
				   }
				%>
                    <button>후기 전체보기</button>
			</div>
		</div>
		레포츠 등록 일자 : <%=regidate %>
		<div>
			<button>티켓 선택</button>
			<div>총 금액</div>
		</div>
	</div>
