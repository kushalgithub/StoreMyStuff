<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
if(session.getAttribute("ID")!=null){
	response.sendRedirect("present.jsp");
}
%>
<body>
<form method="post" action="loginservlet">
<table>
<tr><td>${Err}</td></tr>
<tr><td>User Id:<input name="UserId"/></td></tr>
<tr><td>Password:<input type="password" name="Password"/></td></tr>
<tr><td><input type="submit" value="LogIn"></td></tr>
<tr><td>${success}</td></tr>
</table>
</form>
</body>
</html>