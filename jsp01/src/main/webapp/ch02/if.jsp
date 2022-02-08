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
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String color=request.getParameter("color");
String str="";
if(color.equals("teal")) {
	str="틸블루";
}else if(color.equals("pink")) {
	str="핑크";
}else if(color.equals("green")) {
	str="그린";
}
%>
<div style="color:<%=color%>"><b>
<%=name%>님이 선택한 색상은 <%=str%>입니다.
</b></div>

</body>
</html>