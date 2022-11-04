<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한 줄 게시판</title>
</head>
<body>
	<h2>한 줄 게시판</h2>
	<hr>
	<table border="1" cellspacint="0" cellpadding="0" width="1000">
		<tr bgcolor="pink" height="30">
			<th>번호</th>
			<th>글쓴이</th>
			<th>한줄내용</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach items="${list }" var="dto">
		<tr align="center" height="40">
			<td>${dto.mid }</td>
			<td>${dto.mwriter }</td>
			<td align="left" width="700">${dto.mcontent }</td>
			<td><input type="button" value="×" onclick="javascript:window.location='delete'"></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="한줄쓰기" onclick="javascript:window.location='writeForm'">
			</td>
		</tr>
	
	</table>
</body>
</html>