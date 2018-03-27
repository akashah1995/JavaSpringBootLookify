<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "songs/search" method = 'POST'>
		Search for Song: <input type = "text" name = "find">
		<input type = "submit" value = "Search">
		<br>
	</form>
	<br>
	<a href = '/songs/new'>Add New</a>
	<a href = '/songs/top10'>Top Songs</a>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach items = "${songList}" var = "song" varStatus = "loop">
			<tr>
				<td><a href = "/songs/${song.id}"><c:out value = "${song.title}"></c:out></a></td>
				<td><c:out value = "${song.rating}"></c:out></td>
				<td><a href = "/songs/delete/${song.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>