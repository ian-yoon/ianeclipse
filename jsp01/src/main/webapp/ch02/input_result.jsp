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
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String str = "name: " + name + ", age: " + age;
out.println(str);
%>

</body>
</html>