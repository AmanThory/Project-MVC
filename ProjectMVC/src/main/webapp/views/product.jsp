<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>${HeaderName}</h1>
<div class="container">
<a href="/ProjectMVC/getproducts" method="get">GET PRODUCTS</a>

<form action="/ProjectMVC/success" method="get">
<div class="form-group">
<label for="pName">Product Name: </label>
<input type="text" class="form-control" id="pName" name="pName" placeholder="Enter the product name">
</div>
<div class="form-group">
<label for="pCost">Product Cost: </label>
<input type="text" class="form-control" id="pCost" name="pCost" placeholder="Enter the product cost">
</div>
<button type="submit" class="btn btn-default">Submit</button>
</form>
</div>

</body>
</html>