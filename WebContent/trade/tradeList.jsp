<%@page import="com.dto.TradeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- div class="Resale_list" -->

<%
	List<TradeDTO> list = (List<TradeDTO>) request.getAttribute("list");
%>

<div class="trade_nav">
	<ul>
		<li><a href="TradeListServlet?category=판매">판매</a></li>
		<li><a href="TradeListServlet?category=대여">대여</a></li>
	</ul>
	<div class="option_btn">
		<a href="#">내가 등록한 제품</a> <a href="TradeFormServlet">판매/대여 등록</a>
	</div>
</div>

<div class="products">
	<div class="productsList">
		<%
			for(TradeDTO x:list){
		%>
		<ul class="trade_list">
				<li class="trade_main_img" style="background: #eee;"><a href="#"> <!-- <img src="fff.png"> -->
						<span class="img_src"><%=x.getTrade_main_img()%></span></a>
				</li>
				<li><a href="#"><span class="trade_title"><%=x.getTrade_title()%></span></a></li>
				<li><a href="#"><span class="trade_price"><%=x.getTrade_price()%></span></a></li>
		</ul>
		<%
			}
		%>
	</div>
</div>
