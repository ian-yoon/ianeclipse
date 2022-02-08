<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Map<String,String> map=new HashMap<String,String>();
map.put("kim", "김철수");
map.put("park", "박주연");
map.put("lee", "이진선");
map.put("song", "송희정");
request.setAttribute("map", map);
%>
<jsp:forward page="ex04_result.jsp" />

</body>
</html>