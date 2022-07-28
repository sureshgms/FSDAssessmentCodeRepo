<%@page import="java.util.List"%>
<%@page import="com.bean.Productcategory"%>
<%@page import="com.bean.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Web Store</title>
</head>
<body>
<h2>Create New Product</h2>

<form action="saveProduct" method="post">
		<label>Product name</label> <input type="text" name="productname"><br/><br/>
		<label>Select Category</label>
		
		<select name="pCategory">
			<%
			Object obj1 = session.getAttribute("catList");
			if (obj1 != null) {
				List<Productcategory> catList = (List<Productcategory>) obj1;
				for (Productcategory category : catList) {
			%>

			<option value=<%=category.getCategoryid()%>><%=category.getCategoryname()%></option>
			<%
			}
			}
			%> } } %>
		</select> <br /> <br />
		
		<input type="submit" value="Save">
	</form>
	
	<br />
	<br />
	
    <a href="AdminLoginSuccess.jsp">Back To Home</a><br />
	<br />
    <h2>Available Products</h2>
    <br />
	<table border="1">


		<tr>
			<th>Product Name</th>
			<th>Category Name</th>

		</tr>
		<%
		Object obj = session.getAttribute("prodList");
		if (obj != null) {
			List<Products> prodList = (List<Products>) obj;

			for (Products pList : prodList) {
		%>
		<tr>
			<td><%=pList.getProductname()%></td>
			<td><%=pList.getPcategory().getCategoryname()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

</body>
</html>