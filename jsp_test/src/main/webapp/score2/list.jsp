<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>SCORE</h2>

<table border="1">
<tr>
<td>학번</td>
<td>이름</td>
<td>국어</td>
<td>영어</td>
<td>수학</td>
</tr>

<c:forEach var="row" items="${items}">
<tr>
<td>${row.s_num}</td>
<td>${row.name}</td>
<td>${row.kor}</td>
<td>${row.eng}</td>
<td>${row.math}</td>
</tr>
</c:forEach>

</table>

</body>
</html>
