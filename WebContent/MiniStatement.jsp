<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techaspect.atm.to.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini statement</title>
</head>
<body>

	<%@ include file = "LoginSuccess.jsp" %><br><br><br>
	<%
		User user2 = (User) session.getAttribute("User");
		String transplusamt = user2.getTransaction();
		String[] transandamt = transplusamt.split("#");
		String[] transaction = transandamt[0].split(",");
		String[] transamt =  transandamt[1].split(",");
		String[] transdate =  transandamt[2].split(",");
		for(int i = 0; i < transdate.length ; i++) {
			
	%>
		<span>Transaction ID :   <%=  transaction[i]   %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Transaction Amount :  <%= transamt[i] %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Transaction Date : <%=transdate[i] %> </span><br><br>
	<%} %>
</body>
</html>