<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="emp.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
EmpDAO dao = new EmpDAO();
EmpDTO dto = new EmpDTO();
dto.setEmpno(Integer.parseInt(request.getParameter("empno"))); // 웹에서 넘어오는 건 다 String이라서 int로 바꿔줘야 함
dto.setEname(request.getParameter("ename"));
dto.setSal(Integer.parseInt(request.getParameter("sal")));
dao.insert(dto);
out.println("저장되었습니다.");
%>

</body>
</html>