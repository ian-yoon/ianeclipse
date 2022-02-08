<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jsp03/include/css/bootstrap.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jsp03/include/js/bootstrap.js"></script>
</head>
<body>

<table class="table">
<tr>
<td>번호</td>
<td>이름</td>
<td>나이</td>
<td>주소</td>
<td>전화번호</td>
</tr>
<tr>
<td>1</td>
<td>kim</td>
<td>30</td>
<td>서울시</td>
<td>010-1111-1111</td>
</tr>
<tr>
<td>2</td>
<td>Lee</td>
<td>35</td>
<td>수원시</td>
<td>010-2222-2222</td>
</tr>
<tr>
<td>3</td>
<td>Park</td>
<td>33</td>
<td>세종시</td>
<td>010-3333-3333</td>
</tr>
</table>

<div class="container">
<table class="table table-striped">
<tr>
<td>번호</td>
<td>이름</td>
<td>나이</td>
<td>주소</td>
<td>전화번호</td>
</tr>
<tr>
<td>1</td>
<td>kim</td>
<td>30</td>
<td>서울시</td>
<td>010-1111-1111</td>
</tr>
<tr>
<td>2</td>
<td>Lee</td>
<td>35</td>
<td>수원시</td>
<td>010-2222-2222</td>
</tr>
<tr>
<td>3</td>
<td>Park</td>
<td>33</td>
<td>세종시</td>
<td>010-3333-3333</td>
</tr>
</table>
</div>

<div class="container">
<table class="table table-hover"> <!-- 마우스 올리면 음영이 생김 -->
<tr>
<td>번호</td>
<td>이름</td>
<td>나이</td>
<td>주소</td>
<td>전화번호</td>
</tr>
<tr>
<td>1</td>
<td>kim</td>
<td>30</td>
<td>서울시</td>
<td>010-1111-1111</td>
</tr>
<tr>
<td>2</td>
<td>Lee</td>
<td>35</td>
<td>수원시</td>
<td>010-2222-2222</td>
</tr>
<tr>
<td>3</td>
<td>Park</td>
<td>33</td>
<td>세종시</td>
<td>010-3333-3333</td>
</tr>
</table>
</div>

<hr>
<a class="btn btn-primary">글쓰기</a> <!-- 하이퍼링크인데 버튼처럼 나옴 -->
<div class="text-center">
<ul class="pagination">
<li class="page-item"><a class="page-link" href="#">1</a></li>
<li class="page-item"><a class="page-link" href="#">2</a></li>
<li class="page-item"><a class="page-link" href="#">3</a></li>
<li class="page-item"><a class="page-link" href="#">4</a></li>
</ul>
</div>

</body>
</html>