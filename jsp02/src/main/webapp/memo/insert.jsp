<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="memo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
String writer = request.getParameter("writer");
String memo = request.getParameter("memo");
MemoDTO dto = new MemoDTO();
dto.setWriter(writer);
dto.setMemo(memo);
dto.setIp(request.getRemoteAddr());
MemoDAO dao = new MemoDAO();
dao.insertMemo(dto);
response.sendRedirect("list.jsp");
%>

</body>
</html>