<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post">
		<table border="1">
		<tr>
		<input type="button" value="추가하기" onclick="location.href='insert.do'">
		</tr><br><br>
		<tr>
		<td><input type="text" name="r_no" id="r_no" value="${dto.r_no}" readonly="readonly"></td>
		<td><input type="text" name="r_start" id="r_start"placeholder="r_start"></td>
		<td><input type="text" name="r_end" id="r_end"placeholder="r_end"></td>
		<td><input type="text" name="r_point0" id="r_point0"placeholder="r_point0"></td>
		<td><input type="text" name="r_point1" id="r_point1"placeholder="r_point1"></td>
		<td><input type="text" name="r_point2" id="r_point2"placeholder="r_point2"></td>
		<td><input type="text" name="r_point3" id="r_point3"placeholder="r_point3"></td></tr>
		<tr>
		<td><input type="text" name="r_point4" id="r_point4"placeholder="r_point4"></td>
		<td><input type="text" name="r_point5" id="r_point5"placeholder="r_point5"></td>
		<td><input type="text" name="r_map" id="r_map"placeholder="r_map"></td>
		<td><input type="text" name="r_pay_adult" id="r_pay_adult"placeholder="r_pay_adult"></td>
		<td><input type="text" name="r_pay_teen" id="r_pay_teen"placeholder="r_pay_teen"></td>
		<td><input type="text" name="r_pay_kid" id="r_pay_kid"placeholder="r_pay_kid"></td>
		<td><input type="submit" value="수정">
		<input type="reset" value="취소" onclick="location.href='list.do'"></td></tr>
	</table>
</form>
</body>
</html>