<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
Customer Name          :${name}<br><br>
Customer Mobile Number :${mobno}<br><br>
Customer Address       :${address}<br><br>
Pending Amount         :${amount}<br><br>
<form action="" method="post">
Enter the Amount to update:<input type="text" name="deposit"><br><br>
<input type="submit" value="Repay" formaction="Update">
<input type="submit" value="Add Amount" formaction="AddAmount"><br><br>
<a href="Delete">Delete Customer from list</a>
</form>

</body>
</html>