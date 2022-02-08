<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Date nowDate = new Date();
out.println(nowDate+"<br>");
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a HH:mm:ss"); // 날짜를 String 형식으로 만들어줌
String formatDate = dateFormat.format(nowDate);
%>
현재 날짜는 <%=formatDate%>입니다.

</body>
</html>