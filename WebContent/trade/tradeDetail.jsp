<%@page import="java.util.List"%>
<%@page import="com.dto.TradeCommentsDTO"%>
<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.TradeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
<style type="text/css">
    *{
        padding: 0;margin: 0;
        box-sizing: border-box;
    }
    body{
        width: 100%;
        min-height: 100vh;
    }
    section{
        width: fit-content;
        margin: 40px auto;
    }
    .products_info{
        width: 80%;
        display: flex;
        align-items: center;
        border: 2px solid rgb(201, 225, 235);
        border-radius: 50px;
        position: relative;
        margin: auto;
    }
    .imgframe{
        width: 300px;
        height: 300px;
        margin: 30px 50px;
        overflow: hidden;
    }
    .trade_img{
        display: flex;
    }
    .trade_img li{
        list-style: none;
    }
    .text_info{
        width: 50%;
        margin: inherit;
    }
    .text_info ul{
        width: fit-content;
    }
    .text_info li{
        list-style: none;
        padding: 30px;
    }
    .comment{
       width: 100%;
       text-align: center;
       margin-top: 10%;
    }
    .contentsdiv{
        width: 50%;
        position: relative;
        top: 40px;
        left: 15%;
        
    }
</style> -->
<%
	TradeDTO dto=(TradeDTO)request.getAttribute("dto");
	MemberDTO memberDTO=(MemberDTO)session.getAttribute("login");
	String user_id="";
	if(memberDTO!=null){
		user_id=memberDTO.getUser_id();
	}
	System.out.print("user_id"+user_id);
%>
<section style="margin: 0 auto;">
	<!-- 상품상세정보 -->
	<div class="products_info">
		<div class="imgframe">
			<ul class="trade_img">
				<li><img class="trade_main_img" src="fff.png"><%=dto.getTrade_main_img() %></li>
				<li><img class="trade_sub_img1" src="fff.png"><%=dto.getTrade_sub_img1() %></li>
				<li><img class="trade_sub_img2" src="fff.png"><%=dto.getTrade_sub_img2() %></li>
				<li><img class="trade_sub_img3" src="fff.png"><%=dto.getTrade_sub_img3() %></li>
				<li><img class="trade_sub_img4" src="fff.png"><%=dto.getTrade_sub_img4() %></li>
			</ul>
		</div>
		<div class="text_info">
			<ul>
				<li><%=dto.getTrade_regidate() %></li>
				<li><%=dto.getTrade_title() %></li>
				<li><%=dto.getTrade_price() %></li>
				<li><%=dto.getTrade_phone() %></li>
				<li><%=dto.getTrade_user_name() %></li>
			</ul>
		</div>
	</div>
	<div class="contentsdiv">
		<h2>상품설명</h2>
		<br>
		<p class="trade_contents">
			<%=dto.getTrade_contents() %>
		</p>
	</div>

	<!-- 댓글 -->
	<form action="TradeCommentWrite" method="POST">
		<strong>Comments</strong><br> <input type="hidden"
			name="trade_depth" value=0> <input type="hidden"
			name="trade_id" value="<%=dto.getTrade_id() %>" /> <input
			type="hidden" name="user_id" value="<%=user_id%>" />
		<textarea name="trade_comment" rows="5" cols="100"></textarea>
		<input type="submit" value="댓글 달기" />
	</form>
	<div class="trade_comment_list">
		<input type="hidden" name="re_user_id" value="<%=user_id %>">
		<%
		List<TradeCommentsDTO> list=(List<TradeCommentsDTO>)request.getAttribute("list");
		List<TradeCommentsDTO> list1=(List<TradeCommentsDTO>)request.getAttribute("list1");
		
		for(TradeCommentsDTO aaa: list) {//원댓글
			if(aaa.getTrade_depth() == 0) {
		%>	
			<div class="comment_cont">
				<strong style="color:red"><%=aaa.getUser_id() %></strong>
				<br>
				<span><%=aaa.getTrade_comment() %></span>
				<p><%=aaa.getComment_regidate() %></p>
				<p>depth: <%=aaa.getTrade_depth() %></p>
				<%if(aaa.getUser_id().equals(user_id)){
				%>
				<button class="delBtn" data-commentid="<%=aaa.getTrade_comment_id()%>" data-user="<%=user_id %>" onclick="del()">삭제</button>
				<button class="updateBtn" data-commentid="<%=aaa.getTrade_comment_id()%>" data-user="<%=user_id %>">수정</button>
				<button class="re_comment_btn" value="<%=aaa.getTrade_comment_id()%>">댓글달기</button>
			<% } %>
		<% 
			for(TradeCommentsDTO xxx: list1) {//대댓글 추출
				if(aaa.getTrade_comment_id().equals(xxx.getTrade_comment_level())) {
		%>			
					<div class="comment_cont re">
						<strong style="color:red"><%=xxx.getUser_id() %></strong>
						<br>
						<span><%=xxx.getTrade_comment() %></span>
						<p><%=xxx.getComment_regidate() %></p>
						<p>depth: <%=xxx.getTrade_depth() %></p>
						<%if(xxx.getUser_id().equals(user_id)){
						%>
							<button class="delBtn" data-commentid="<%=xxx.getTrade_comment_id()%>" data-user="<%=user_id %>" onclick="del()">삭제</button>
							<button class="updateBtn" data-commentid="<%=xxx.getTrade_comment_id()%>" data-user="<%=user_id %>">수정</button>
						<% } %>
					</div>
				<% }%>	
			<% 	} %>
				</div>
			<% 	} %>
			<% } %>	
		
		
        </div>
			</section>