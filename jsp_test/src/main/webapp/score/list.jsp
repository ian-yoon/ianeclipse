<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="score.*" %>
<%@ page import="java.util.List" %>
<table border="1">
<tr>
<td>학번</td>
<td>이름</td>
<td>국어</td>
<td>영어</td>
<td>수학</td>
</tr>
<%
ScoreDAO dao = new ScoreDAO();
List<ScoreDTO> items = dao.list();
for(ScoreDTO dto : items) {
%>
<tr>
<td><%=dto.getS_num()%></td>
<td><%=dto.getName()%></td>
<td><%=dto.getKor()%></td>
<td><%=dto.getEng()%></td>
<td><%=dto.getMath()%></td>
</tr>
<%
}
%>
</table>
</body>
</html>