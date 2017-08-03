<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>

</head>
<body>
<table align="center">
<td>

<c:url var="action" value="/j_spring_security_check" />
<form name="loginForm"  action="${action}" method="post">

<!-- <form action="validate"> -->

UserName:&nbsp;&nbsp;<input type="text" name="userName">  <br>
Password:&nbsp;&nbsp;&nbsp;<input type="text"  name="password">  <br>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<button type="submit" class="btn btn-warning"><i class="fa fa-sign-in" aria-hidden="true"></i> Login</button>


<!--  <input type="submit"  value="Login"class="btn btn-primary"> -->

</form>
</td>
</table>



</body>
</html>