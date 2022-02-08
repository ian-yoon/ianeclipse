<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://www.google.com/jsapi"></script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
google.load("visualization", "1", {"packages" : ["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {
	var json_data=$.ajax({
		url: "/jsp03/chart/sample.json",
		async: false // 기본값은 true인데 false하면 동기화를 한다는 뜻. 차트 데이터를 다 불러온 다음에 차트를 그린다는 뜻이 됨. 기본값으로 두면 차트 데이터를 불러오기도 전에 차트를 그리는 셈.
	}).responseText;
	// 차트 데이터를 데이터 테이블로 보내는 작업 시작
	var data=new google.visualization.DataTable(json_data);
	var chart=new google.visualization.PieChart(document.getElementById("chart_div"));
	chart.draw(data, {
		title: "차트 예제",
		width: 600,
		height: 440
	});
}
</script>
</head>
<body>

<div id="chart_div"></div>
<button id="btn" type="button" onclick="drawChart()">refresh</button>

</body>
</html>