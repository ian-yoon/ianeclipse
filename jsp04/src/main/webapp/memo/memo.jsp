<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		list();
		$("#btnSave").click(function() {
			insert();
		});
		$("#btnSearch").click(function() {
			list();
		});
	});
	function list() {
		var params = "searchkey=" + $("#searchkey").val() + "&search="
				+ $("#search").val();
		$.ajax({
			type : "post",
			data : params,
			url : "/jsp04/memo_servlet/list.do",
			success : function(txt) {
				$("#result").html(txt);
			}
		});
	}
	function insert() {
		var writer = $("#writer").val();
		var memo = $("#memo").val();
		var params = "writer=" + writer + "&memo=" + memo;
		$.ajax({
			type : "post",
			url : "/jsp04/memo_servlet/insert.do",
			data : params,
			success : function() {
				list("search=");
				$("#writer").val("");
				$("#memo").val("");
			}
		});
	}
</script>
</head>
<body>

	<h2>한줄 메모장</h2>
	<input id="writer" placeholder="이름">
	<input id="memo" placeholder="메모">
	<input type="button" id="btnSave" value="확인">
	<br>
	<select id="searchkey">
		<option value="writer">이름</option>
		<option value="memo">메모</option>
		<option value="writer_memo">이름+메모</option>
	</select>
	<input type="text" id="search" value="${search}">
	<input type="button" id="btnSearch" value="조회">
	<div id="result"></div>

</body>
</html>