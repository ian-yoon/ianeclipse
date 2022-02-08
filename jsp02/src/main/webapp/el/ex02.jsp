<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post">
	이름 : <input name="name" value="${param.name}">
	나이 : <input name="age" value="${param.age}">
	<input type="submit" value="확인">
</form>
이름 : ${param.name}
나이 : ${param.age}

</body>
</html>