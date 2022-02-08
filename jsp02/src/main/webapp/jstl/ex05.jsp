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

<c:forEach var="i" begin="0" end="100" step="5" varStatus="s">
	${s.index} / ${s.count} :
	<c:if test="${i % 2 == 0}">
		<span style="font-size:${110-i}px; color:teal;">hello</span>
	</c:if>
	<c:if test="${i % 2 == 1}">
		<span style="font-size:${110-i}px; color:pink;">hello</span>
	</c:if>
	<br>
</c:forEach>

</body>
</html>