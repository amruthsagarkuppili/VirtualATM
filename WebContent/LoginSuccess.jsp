<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techaspect.atm.to.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success login</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("User");
		String fname = user.getFname();
	%>
	
	<span style = "font-size: 24px;"><b>Welcome <%= fname %></b></span><br><br><br>
	<a href = "withdraw.jsp">Withdraw cash</a><br><br>
	<a href = "BalanceEnquiry">Balance Enquiry</a><br><br>
	<a href = "MiniStatement">Mini Statement</a>
</body>
</html>