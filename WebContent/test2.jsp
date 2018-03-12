<%@page import="test.ListPatient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
     Document document=new Document();
     try{
   PdfWriter.getInstance(document,new FileOutputStream("reporttest1.pdf"));
  document.open();  
     document.add(new Paragraph("this is to test"));
     }catch(Exception e){}
 finally{ document.close();}
    %>
</body>
</html>