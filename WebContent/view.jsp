<%@page import="dao_pkg.docs_dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%@page import="model_pkg.*" %>

<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("ID")==null){
	response.sendRedirect("Login.jsp");
}
%>

<% Blob image = null;
byte[ ] imgData = null ;
try {
documents_model rff = docs_dao.getMaterial(Integer.parseInt(request.getParameter("materialid")));	
image = rff.getFile();
imgData = image.getBytes(1,(int)image.length());
response.setContentType(rff.getFileType());
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} 



%>
</body>
</html>