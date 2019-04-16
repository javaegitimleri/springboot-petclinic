<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="owner" method="post">
		First Name:<form:input path="firstName"/>
		<form:errors path="firstName" cssStyle="color:red"/>
		<br/>
		Last Name:<form:input path="lastName"/>
		<form:errors path="lastName" cssStyle="color:red"/>
		<br/>
		<form:button name="submit">Create</form:button>
	</form:form>
</body>
</html>