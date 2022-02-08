<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
HashMap<String,String> map = (HashMap<String,String>)request.getAttribute("map");
String[] fruits={"kim", "park", "lee", "song"};
for (String f : fruits) {
	out.println( f + "=>" + map.get(f) + "<br>");
}
%>

${map["kim"]}<br>
${map["park"]}<br>
${map["lee"]}<br>
${map["song"]}<br>
${map.kim}<br>
${map.park}<br>
${map.lee}<br>
${map.song}<br>

</body>
</html>