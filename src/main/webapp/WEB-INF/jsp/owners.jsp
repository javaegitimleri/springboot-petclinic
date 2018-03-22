<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr style="font-weight: bold;" bgcolor="lightblue">
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
			</tr>
		</thead>
		<c:forEach items="${owners}" var="owner" varStatus="status">
			<tr bgcolor=${status.index % 2 == 0?'white':'lightgray'}>
				<td>${owner.id}</td>
				<td>${owner.firstName}</td>
				<td>${owner.lastName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>