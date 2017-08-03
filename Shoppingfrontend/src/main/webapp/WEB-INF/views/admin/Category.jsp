<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>

</head>
<body>
<div class="container">


<h2>  Manage Categories  </h2>

<div id="CreateCategory">

	<form action="manage_category_add" method="get">

		<input type="text" name="id"> <input type="text" name="name">
		<input type="text" name="description"> 
		<input type="submit" class="btn btn-success" value="Create Category">
	</form>
	
</div>	


<div id="UpdateCategory">

	<form action="manage_category_update" method="post">

		<input type="text" name="cId"  value="${selectedCategory.id}"> 
		<input type="text" name="cName" value="${selectedCategory.name}"> 
		<input type="text" name="cDescription" value="${selectedCategory.description}"> 
        <input type="submit" class="btn btn-info"	value="Update Category">
	</form>
	
</div>	






	
	<h2> Delete / Update the Categories  </h2>
	<div id="ShowCategories">
	
		<table border="3">
		<thead align="center">
		<tr>
		<td><strong> Category ID</strong></td>
		<td><strong> Category Name</strong></td>
		<td><strong>Category Discription</strong>  </td>
		<td> <strong> Action </strong> </td>
		</tr>
		</thead>
		
	<c:forEach var="category" items="${categoryList}">
	
	<tr>  
	 <td> ${category.id} </td>
	  <td> ${category.name} </td>
	   <td> ${category.description} </td>
	   
	 <%--   <td> <a href="manage_category_delete/${category.id}"> Delete | </a>   
	   <a href="manage_category_edit/${category.id}"> Edit  </a>    </td> --%>
	   
	   <td>
	   
	  <a href="<c:url value='/manage_category_edit/${category.id}' />"> <button type="button" class="btn btn-primary">Edit</button></a>
					
	  <a href="<c:url value='/manage_category_delete/${category.id}' />"><button type="button" class="btn btn-danger">Delete</button></a>
	   
	   
	   </td>
	
	
	
	</tr>

	</c:forEach>
	
	
	</table>
	
	</div>
</div>

</body>
</html>
















