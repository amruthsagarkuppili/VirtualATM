<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techaspect.atm.to.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance Enquiry</title>
</head>
<body>
	<%
		User user1 = (User) session.getAttribute("User");
		String balance = user1.getAccbal();
	%>
	
	<%@ include file = "LoginSuccess.jsp" %><br><br><br>
	
	<span style  = "font-size : 20px ; color: green;"><b>Your account balance is  <%= balance %></b></span><br><br><br>
	
	
	
	
</body>
</html>