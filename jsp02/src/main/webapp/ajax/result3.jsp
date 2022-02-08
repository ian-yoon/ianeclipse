<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ajax.KeywordDAO" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
KeywordDAO dao = new KeywordDAO();
String keyword = request.getParameter("search");
List<String> items = dao.list(keyword);
for(String str : items) {
	out.println(str + "<br>");
}
%>

</body>
</html>