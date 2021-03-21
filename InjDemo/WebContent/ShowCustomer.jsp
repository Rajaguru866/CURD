<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<%
	response.setHeader("cache-control","no-cache,no-store,must-revalidate");	
	String uname = (String) session.getAttribute("uname");
	String pass = (String) session.getAttribute("pass");
	if(uname==null || uname.equals("admin")==false || pass.equals("me")==false )
	{
		response.sendRedirect("/InjDemo/Admin.jsp");
	}

%>
Customer Name          :${name}<br><br>
Customer Mobile Number :${mobno}<br><br>
Customer Address       :${address}<br><br>
Pending Amount         :${amount}<br><br>
<form action="" method="post">
Enter the Amount to update:<input type="text" name="deposit"><br><br>
<input type="submit" value="Repay" formaction="Search/Repay">
<input type="submit" value="Add Amount" formaction="Search/AddAmount"><br><br>
<a href="Search/Delete">Delete Customer from list</a><br><br>
<a href="/InjDemo/Admin.jsp">back</a>
</form>

</body>
</html>