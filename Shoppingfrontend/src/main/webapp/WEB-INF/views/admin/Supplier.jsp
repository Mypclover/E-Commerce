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
<div class="col-md-offset-2 col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>  Manage Supplier  </h4>
</div>
<br/>
<div id="CreateSupplier">

	<div class="form-group">
	<form action="manage_supplier_add" method="get">

		<input type="text" name="sId"> <input type="text" name="sName">
		<input type="text" name="sDescription"> 
		<input type="submit" class="btn btn-success"	value="Create Supplier">
	</form>
	
</div>	


<div id="UpdateSupplier">

	<form action="manage_supplier_update" method="post">

		<input type="text" name="cId"  value="${selectedSupplier.id}"> 
		<input type="text" name="cName" value="${selectedSupplier.name}">
		<input type="text" name="cDescription" value="${selectedSupplier.description}"> 
        <input type="submit"	class="btn btn-info" value="Update Supplier">
	</form>
	
</div>	

</div>
</div>
<div class="panel-body">


	
	<h2> Delete / Update the Supplier  </h2>
	<div id="ShowSupplier">
	
		<table border="3">
		<thead align="center">
		<tr>
		<td><strong> Supplier ID</strong></td>
		<td><strong> Supplier Name</strong></td>
		<td><strong> Supplier Description</strong></td>
		<td><strong> Action </strong> </td>
		</tr>
		</thead>
		
	<c:forEach var="supplier" items="${supplierList}">
	
	<tr>  
	 <td> ${supplier.id} </td>
	  <td> ${supplier.name} </td>
	   <td> ${supplier.description} </td>
	   
	 <%--   <td> <a href="manage_supplier_delete/${supplier.id}"> Delete | </a>   
	   <a href="manage_supplier_edit/${supplier.id}"> Edit  </a>    </td> --%>
	   
	   <td>
	   <a href="<c:url value='/manage_supplier_edit/${supplier.id}' />"><button type="button" class="btn btn-primary">Edit</button></a>
					
	  <a href="<c:url value='/manage_supplier_delete/${supplier.id}' />"><button type="button" class="btn btn-danger">>Delete</button></a>
	   
	   
	   </td>
	
	</tr>
	
	</c:forEach>
	
	
	</table>
	
	
	</div>
	</div>
</div>
</div>
</body>
</html>
