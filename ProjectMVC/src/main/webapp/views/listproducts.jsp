<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
  <script src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function() {
	  
	  $.ajax({
		  url:'/ProjectMVC/getjsonproducts',
		  method: 'post',
		  dataType: 'json',
		  success: function (data){
			  $('#myDataTable').dataTable({
				  data: data,
				  columns: [
					  {'data' : 'pName'},
					  {'data' : 'pCost'},
				  ]		  
			  });
		  }
	  }); 
  });
  </script>
  
<title>Insert title here</title>
</head>
<body>

<a href="success.jsp">Success Page</a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="#">Add Products Page</a>
</sec:authorize>
<a href="${pageContext.request.contextPath}/logout">logout</a>

<h1>Welcome Mr/Ms. ${un}</h1>
<table>
<c:forEach items="${ lp }" var = "products">
<tr>
	<td> ${products.getpName() }</td>
	<td> ${products.getpCost() }</td>
</tr>
</c:forEach>
</table>
<table id="myDataTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
<thead>
<tr>
	<th>pName</th>
	<th>pCost</th>
</tr>
</thead>
</table>

</body>
</html>