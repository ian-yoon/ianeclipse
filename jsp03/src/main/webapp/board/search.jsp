<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function() {
	$("#btnWrite").click(function() {
		location.href="/jsp03/board/write.jsp";
	});
});
function list(page) {
	location.href="/jsp03/board_servlet/list.do?cur_page=" + page + "&search_option=${search_option}&keyword=${keyword}";
}
</script>
</head>
<body>

<h2>게시판</h2>

<form name="form1" method="post" action="/jsp03/board_servlet/search.do">
<select name="search_option">
<c:choose>
<c:when test="${search_option == null || search_option == 'all'}">
<option value="all" selected>전체검색</option>
<option value="writer">이름</option>
<option value="subject">제목</option>
<option value="contents">내용</option>
</c:when>
<c:when test="${search_option == 'writer'}">
<option value="all">전체검색</option>
<option value="writer" selected>이름</option>
<option value="subject">제목</option>
<option value="contents">내용</option>
</c:when>
<c:when test="${search_option == 'subject'}">
<option value="all">전체검색</option>
<option value="writer">이름</option>
<option value="subject" selected>제목</option>
<option value="contents">내용</option>
</c:when>
<c:when test="${search_option == 'contents'}">
<option value="all">전체검색</option>
<option value="writer">이름</option>
<option value="subject">제목</option>
<option value="contents" selected>내용</option>
</c:when>
</c:choose>
</select>

<input name="keyword" value="${keyword}">
<input type="submit" value="검색" id="btnSearch">
<button type="button" id="btnWrite">글쓰기</button>
</form>

<table border="1" width="900px">
<tr>
<th>번호</th>
<th>이름</th>
<th>제목</th>
<th>날짜</th>
<th>조회수</th>
<th>첨부파일</th>
<th>다운로드</th>
</tr>
<c:forEach var="dto" items="${list}">
<tr align="center">
<td>${dto.num}</td>
<td>${dto.writer}</td>
<td align="left">
<c:forEach var="i" begin="1" end="${dto.re_depth}">
&nbsp;&nbsp;
</c:forEach>
<c:if test="${dto.re_depth > 0}">Re:</c:if>
<a href="/jsp03/board_servlet/view.do?num=${dto.num}">${dto.subject}</a>
<c:if test="${dto.count_comments > 0}">
<span style="color:pink">(${dto.count_comments})</span>
</c:if>
</td>
<td>${dto.reg_date}</td>
<td>${dto.hit}</td>
<td align="center">
<c:if test="${dto.filesize > 0}">
<a href="/jsp03/board_servlet/download.do?num=${dto.num}">
<img src="/jsp03/images/guinea.jpg" width="30px" height="30px"></a>
</c:if>
</td>
<td>
${dto.down}
</td>
</tr>
</c:forEach>
<tr align="center">
<td colspan="7">
<c:if test="${page.curPage > 1}">
<a href="#" onclick="list('1')">[처음]</a>
</c:if>
<c:if test="${page.curBlock > 1}">
<a href="#" onclick="list('${page.prevPage}')">[이전]</a>
</c:if>
<c:forEach var="num" begin="${page.blockStart}"
end="${page.blockEnd}">
<c:choose>
<c:when test="${num == page.curPage}">
<span style="color:red">${num}</span>
</c:when>
<c:otherwise>
<a href="#" onclick="list('${num}')">${num}</a>
</c:otherwise>
</c:choose>
</c:forEach>
<c:if test="${page.curBlock < page.totBlock}">
<a href="#" onclick="list('${page.nextPage}')">[다음]</a>
</c:if>
<c:if test="${page.curPage < page.totPage}">
<a href="#" onclick="list('${page.totPage}')">[마지막]</a>
</c:if>
</td>
</tr>
</table>

</body>
</html>