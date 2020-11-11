<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("login");
	String username = dto.getUser_name();
%>
<b><%= username %> 님의 마이페이지</b><br>
<button>계정관리</button>
<a href="MainAccountManagement.jsp">나의예약내역</a>
<button>나의중고거래</button>
<button>나의문의내역</button>