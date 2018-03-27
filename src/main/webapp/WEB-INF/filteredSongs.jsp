<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>

	<c:forEach items = "${filteredSongs}" var = "song" varStatus = "loop">
		<tr>
			<td><a href = "/songs/${song.id}"><c:out value = "${song.title}"></c:out></a></td>
			<td><c:out value = "${song.rating}"></c:out></td>
			<td><a href = "/songs/delete/${song.id}">Delete</a></td>
		</tr>
	</c:forEach>
	
	</table>
	
	<a href = "/dashboard">Back</a>

</body>
</html>