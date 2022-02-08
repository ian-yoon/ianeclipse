<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
${result}
<%-- ${sessionScope.result} 조금 더 정확하게 하려면 이렇게--%>
</body>
</html>