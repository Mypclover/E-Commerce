<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>

</head>
<body>
<h2>Signup Form</h2>
<table align="center">
<td>
<form  commandName="user"  action="signUp" method="post">

	<label><b> User Id</b></label>
      <input type="text" placeholder="Enter id" name="id">
      <br>
      <label><b>Enter Name</b></label>
      <input type="text" placeholder="Enter Name" name="name" required>
      <br>
      <label><b>Enter Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
      <br>
      <label><b>Enter Mobile No</b></label>
      <input type="tel" placeholder="Enter Mobile No" name="contact" required>
      <br>
      <button type="submit" class="signupbtn" value="signUp">Sign Up</button>

</form>
</td>
</table>

<!-- <form action="validate">
User Name: <input type="text" name="RuserName">
Name:	   <input type="text" name="Rname">
Enter Password:	   <input type="password" name="Rpassword">
 <input type="submit"  value="Login"class="btn btn-primary">

</form> -->


</body>
</html>
