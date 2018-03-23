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
	<h1>PetClinic Login Page</h1>
	<form action="login" method="post">
		Username:<input name="username" type="text" /><br /> Password:<input
			name="password" type="password" /><br /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
		Remember Me:<input name="remember-me" type="checkbox"><br />
		<input type="submit" value="Login">
	</form>
	<font color="red"> <c:if test="${not empty param.loginFailed}">
			<c:out value="Login Failed, Incorrect Username or Password"></c:out>
		</c:if>
</body>
</html>