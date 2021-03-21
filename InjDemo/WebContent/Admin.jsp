<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<%
	response.setHeader("cache-control","no-cache,no-store,must-revalidate");
	String uname = (String) session.getAttribute("uname");
	String pass = (String) session.getAttribute("pass");
	if(uname==null || uname.equals("admin")==false || pass.equals("me")==false )
	{
		response.sendRedirect("Login.jsp");
	}

%>
<a href="CreateCustomer.jsp">Create Customer</a><br><br>
<form action="Admin/Search" method="get">
Enter the Customer Mobile Number<input type="text" name="mobno">
<input type="submit" value="submit" formaction="Admin/Search"><br><br>
<input type="submit" value="logout" formaction="Logout">
</form>
</body>
</html>