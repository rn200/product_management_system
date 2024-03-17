<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">Change Product Details</h1>

<form action="${pageContext.request.contextPath }/handle-product" method="post">
<input type="text" value=" ${product.id }" name="id">
<div class="form-group">
    <label for="exampleInputName">Product Name</label>
    <input type="text" 
    class="form-control" 
    id="exampleInputName" 
    name="name"
    placeholder="Enter product Name"
    value="${product.name }">
    
  </div>
  
  <div class="form-group">
    <label for="description">Product Description</label>
    <textarea class="form-control" 
             rows="5" 
             name="description" 
             id="description" 
             placeholder="enter the product description">${product.description }</textarea>   
  </div>
  
  <div class="form-group">
    <label for="price">Product Price</label>
    <input type="text" 
    class="form-control" 
    id="price" 
    name="price"
     placeholder="Enter product Price"
     value="${product.price }">   
  </div>
  
  <div class="container text-center">
  <a href="${pageContext.request.contextPath }/" 
  class="btn btn-outline-danger">Back</a>
  <button type="submit" class="btn btn-warning">Update</button>
  </div>
</form>
</div>

</div>
</div>
</body>
</html>