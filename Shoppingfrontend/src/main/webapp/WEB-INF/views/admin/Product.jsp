 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>	
<!-- <link rel="stylesheet" href="resources/css/CategoryList.css"> -->
	
<div class="container">

	<div class="row">
	
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				
				<div class="panel-body">
					
					<!-- Form Elements -->
					<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>
					<sf:form class="form-horizontal" commandName="product"
						action="${addAction}" method="POST" enctype="multipart/form-data">
						
						
						
						<div class="form-group">
							<label class="control-label col-md-4" for="id">Product Id:</label>
							
						<c:choose>
							<c:when test="${!empty product.id}">	
								<div class="col-md-8">
									<sf:input type="text" path="id" value="" disabled="true" readonly="true" class="form-control"/>
								</div>
							</c:when>
							
							<c:otherwise>
							<div class="col-md-8">
									<sf:input type="text" path="id" id="id" placeholder="Product Id" class="form-control"/>
									<sf:errors path="id" cssClass="help-block" element="em"/>
							</div>
							</c:otherwise>
						</c:choose>
								
									
																
					
								
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="discription">Product Description:</label>
							<div class="col-md-8">
								<sf:textarea path="discription" id="discription" placeholder="Write a Description for Product" cols="4" rows="" class="form-control"/>
								<sf:errors path="discription" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="price">Product Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="price" id="price" placeholder="Product Price in &#8377; " class="form-control"/>
								<sf:errors path="price" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<%--  <div class="form-group">
							<label class="control-label col-md-4" for="quantity">Product Quantity:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Enter Quantity" class="form-control"/>
								<sf:errors path="quantity" cssClass="help-block" element="em"/>
							</div>
						</div> --%>
						
												
						
						<div class="form-group">
							<label class="control-label col-md-4" for="category.name">Category:</label>
							<div class="col-md-8">
								<sf:select  path="category.name" id="category.name"  class="form-control"
								items="${categoryList}"
								itemLabel="name"
								itemValue="id"
								/>
								
							</div>
						</div>
					
					<div class="form-group">
							<label class="control-label col-md-4" for="supplier.name">Supplier:</label>
							<div class="col-md-8">
								<sf:select  path="supplier.name" id="supplier.name"  class="form-control"
								items="${supplierList}"
								itemLabel="name"
								itemValue="id"
								/>
							
							</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-4" for="image">Select an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="image" id="image"  class="form-control"/>
								<sf:errors path="image" cssClass="help-block" element="em"/>
							</div>
					
					</div>
					
					
					<div class="form-group">
					
					<c:if test="${!empty product.name}">	
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="update" id="update" value="Update Product" class="btn btn-primary"/>
							</div>
					</c:if>
					
					<c:if test="${empty product.name}">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="add" id="add" value="Add Product" class="btn btn-primary"/>
							</div>
					
					</c:if>		
					</div>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					
					
					
					</sf:form>
					
				</div>
			</div>
		</div>

	</div>
	
	<h2 align="center">Product List</h2>

	<div id="ShowCategories">

		<!-- <div class="container"> -->
			

				<table class="table table-striped custab">
					<thead>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<!-- <th>Quantity</th> -->
							<th>Category</th>
							<th>Supplier</th>
							<th>Edit</th>
							<th>Delete</th>
							<!-- <th class="text-center">Action</th> -->
						</tr>
					</thead>

					<c:forEach var="product" items="${productList}">

						<tr>
							<td>${product.id}</td>
							<td><img src="resources/images/${product.id}.jpg" height="80px" width="75px" /></td>
							<td>${product.name}</td>
							<td>${product.discription}</td>
							<td>${product.price}</td>
							<%-- <td align="center">${product.quantity}</td> --%>
							<td>${product.category.name}</td>
							<td>${product.supplier.name}</td>
							
							<td class="text-center">
							<a class="btn btn-info btn-xs" href="<c:url value = '/manage_product_edit/${product.id}'/>">
							 <span class="glyphicon glyphicon-edit"></span> Edit</a> 
							 </td>
							 <td>
							 <a href="<c:url value ='/manage_product_delete/${product.id}'/>" class="btn btn-danger btn-xs"> 
							 <span class="glyphicon glyphicon-remove"></span> Delete
							</a></td>
						</tr>

					</c:forEach> 

				</table>

			

		</div>
	
	
	
</div>
</body>
</html>