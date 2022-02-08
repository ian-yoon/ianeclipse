<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="emp.*" %>
<%@ page import="java.util.List" %>

<table border="1">
<tr>
<td>사번</td>
<td>이름</td>
<td>급여</td>
</tr>

<%
EmpDAO dao = new EmpDAO();
List<EmpDTO> items = dao.list();
for(EmpDTO dto : items) {
%>
<tr>
<td><%=dto.getEmpno()%></td>
<td><%=dto.getEname()%></td>
<td><%=dto.getSal()%></td>
</tr>
<%
}
%>

</table>

</body>
</html>