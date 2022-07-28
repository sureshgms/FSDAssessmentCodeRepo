<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Productcategory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Web Store</title>
</head>
<body>
	<h2>Create new Product Categories</h2>
	<br />
	<form action="saveCategory" method="post">
		<label>Category name</label> <input type="text" name="categoryname"><br />
		<input type="submit" value="Save">
	</form>

	<br />
	<br />
	<a href="AdminLoginSuccess.jsp">Back To Home</a>
	<br />
	<br />

	<h2>Available Categories</h2>
	<br />

	<table border="1">


		<tr>

			<th>Category Name</th>

		</tr>
		<%
		Object obj = session.getAttribute("catList");
		if (obj != null) {
			List<Productcategory> catList = (List<Productcategory>) obj;

			for (Productcategory category : catList) {
		%>
		<tr>
			<td><%=category.getCategoryname()%></td>
			<%--<td>Sample text</td> --%>
		</tr>
		<%
		}
		}
		%>
	</table>

</body>
</html>