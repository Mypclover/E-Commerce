<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>
<title>GamePedia An Game Encyclopedia</title>

</head>
<body>
	

	<jsp:include page="Menu.jsp"></jsp:include>
	
	<!-- Display messages -->
	<div class="container-fluid">
		<marquee>
			<strong class="text-primary">${message} </strong>
			<strong class="text-success">${successMessage} </strong>
			<strong class="text-danger">${errorMessage} </strong>
		</marquee>
	</div>
	


	<c:if test="${isAdmin=='true'}">

		<jsp:include page="admin/AdminHome.jsp"></jsp:include>

	</c:if>
	
	<!-- Display Admin Control Panel -->
	<c:if test="${isUserClickedProductByCategory=='true'}">
		<jsp:include page="CategoryProducts.jsp"></jsp:include>
	</c:if>
	
	<!-- Display Checkout Message -->
	<c:if test="${isUserCheckedOut=='true'}"> 
		<jsp:include page="user/checkOut.jsp"></jsp:include>
	</c:if>
	
	<!-- Display cart content -->
	<c:if test="${isUserClickedCart=='true'}">
		<jsp:include page="user/myCart.jsp"></jsp:include>
	</c:if>
	

	<c:if test="${isAdminClickedCategories=='true'}">

		<jsp:include page="admin/Category.jsp"></jsp:include>

	</c:if>

	<c:if test="${isAdminClickedSuppliers=='true'}">
		<jsp:include page="admin/Supplier.jsp"></jsp:include>
		<br>
	</c:if>

	<c:if test="${isAdminClickedProducts=='true'}">
		<jsp:include page="admin/Product.jsp"></jsp:include>
		<br>
	</c:if>

	<c:if test="${isUserSelectedProduct=='true'}">
		<jsp:include page="ProductPage.jsp"></jsp:include>
	</c:if>
	
	<br>
	<!-- Display LoginPage -->
	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>

	<!-- Display Registration Page -->
	<c:if test="${isUserClickedRegistration=='true'}">
		<jsp:include page="Register.jsp"></jsp:include>
	</c:if>
<div>
	<!-- Display Carousel and Products -->
	<c:if test="${isUserAtHomePage=='true'}">
		<jsp:include page="Carousel.jsp"></jsp:include>
		<jsp:include page="AllProducts.jsp"></jsp:include>
	</c:if>
</div>






</body>
</html>