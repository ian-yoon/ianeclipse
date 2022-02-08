<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="common.MyCookie" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String count = MyCookie.getCookie(request.getCookies(), "count");
int intCount = 0;
Date date = new Date();
long now_time = date.getTime();
String visitTime = MyCookie.getCookie(request.getCookies(), "visit_time");
long visit_time = 0;
if (visitTime != null && !visitTime.equals("")) {
	visit_time = Long.parseLong(visitTime);
}
if (count == null || count.equals("")) {
	response.addCookie(new Cookie("count", "1"));
	response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
	intCount = 1;
} else {
	long period = now_time - visit_time;
	intCount = Integer.parseInt(count);
	if (period > 3 * 1000) {
		intCount++;
		response.addCookie(new Cookie("count", Integer.toString(intCount)));
		response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
	}
}
%>
<%=intCount %>번째 방문입니다.
</body>
</html>