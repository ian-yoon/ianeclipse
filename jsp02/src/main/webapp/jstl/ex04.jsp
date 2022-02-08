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

	<c:set var="num" value="<%=100%>" scope="page" />
	<c:set var="num" value="200" scope="request" />
	<c:set var="num" value="300" scope="session" />
	<c:set var="num" value="400" scope="application" />
	${pageScope.num}
	<br> ${requestScope.num}
	<br> ${sessionScope.num}
	<br> ${applicationScope.num}
	<br>
	<c:if test="${num > 10}">
	${num} > 10<br>
	</c:if>

	<!-- 아래는 위의 식을 java 식으로 쓴 것 -->

	<%
	int num = (int) pageContext.getAttribute("num");
	out.println("num=" + num + "<br>");
	pageContext.setAttribute("num", 100);
	request.setAttribute("num", 200);
	session.setAttribute("num", 300);
	application.setAttribute("num", 400);

	out.println(pageContext.getAttribute("num") + "<br>");
	out.println(request.getAttribute("num") + "<br>");
	out.println(session.getAttribute("num") + "<br>");
	out.println(application.getAttribute("num") + "<br>");
	%>

</body>
</html>