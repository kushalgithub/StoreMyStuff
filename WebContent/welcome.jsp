<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model_pkg.documents_model" %>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<%
if(session.getAttribute("ID")==null){
	response.sendRedirect("Login.jsp");
}
%>


<h3>Login successful!!!</h3>
FIRSTNAME:
<% out.println(session.getAttribute("fname")); %>



<form action="logoutservlet" method="post">

<table align="right">
<tr>
<td>
<input type="submit" value="Logout">
</td>
</tr>
</table>

</form>

    
    <form action="uploadservlet" method="post"
    enctype="multipart/form-data">
<table>
<tr>
<td>Browse File:<input type="file" name="fileupload" ></td>
</tr>
<tr>
<td>Comments:<textarea name="comments" rows="10" cols="30" ></textarea></td>
</tr>
<tr>
<td><input type="submit" value="Submit"></td>
</tr>
</table>

<table border="1px" align="center">						
<tr><td>Files</td><td>Description</td></tr>
<%				
					ArrayList<documents_model> materiallist1 = (ArrayList<documents_model>)request.getAttribute("materiallist");
					for (int i = 0; i < materiallist1.size(); i++) {
				%>
				<tr><td><a href="view.jsp?materialid=<%=materiallist1.get(i).getDocId() %>"><%=materiallist1.get(i).getFileName() %></a></td><td><%=materiallist1.get(i).getComments()%></td></tr>
				<%} %>
		</table>
		
</form>

</body>
</html>