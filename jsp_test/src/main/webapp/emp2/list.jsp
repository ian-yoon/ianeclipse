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

<h2>사원목록</h2>

<table border="1">
<tr>
<td>사번</td>
<td>이름</td>
<td>급여</td>
</tr>

<c:forEach var="row" items="${items}">
<tr>
<td>${row.empno}</td>
<td>${row.ename}</td>
<td>${row.sal}</td>
</tr>
</c:forEach>

</table>
</body>
</html>