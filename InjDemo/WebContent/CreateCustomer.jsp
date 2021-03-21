<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
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
<form action="Admin/Create" method="post">
Enter the Customer Name :<input type="text" name="name"><br><br>
Enter the Mobile Number :<input type="text" name="mobno"><br><br>
Enter the Address       :<input type="text" name="address"><br><br>
<input type="submit" value="submit"><br><br>
<a href="Admin.jsp">back</a>
</form>
</body>
</html>