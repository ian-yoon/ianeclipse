<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	int[] nums = { 10, 70, 80, 50, 40, 30, 20 };
	%>
	<c:set var="num" value="<%=nums%>" />
	<c:forEach var="n" items="${num}">
	${n},
</c:forEach>
	<c:set var="season" value="spring" />
	<c:choose>
		<c:when test="${season == 'spring'}">
			<img src="../images/guinea.jpg">
		</c:when>
		<c:when test="${season == 'summer'}">
			<img src="../images/hamster.jpg">
		</c:when>
		<c:when test="${season == 'autumn'}">
			<img src="../images/jervyll.jpg">
		</c:when>
		<c:when test="${season == 'winter'}">
			<img src="../images/panda.jpg">
		</c:when>
		<c:otherwise>otherwise</c:otherwise>
	</c:choose>

</body>
</html>