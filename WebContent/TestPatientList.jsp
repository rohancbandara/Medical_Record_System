<%@page import="com.rcb.model.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Student List</h1>  
           <%  
           List<Patient> studentList = (ArrayList<Patient>)request.getAttribute("patientList");  
           %>  
           <table>  
           <tr>  
           <td>Patient Id</td>  
           <td>Patient First Name</td>  
           <td>Patient Last Name</td>  
           <td>Edit</td>  
           <td>Delete</td>  
           </tr>  
           <% for(Patient patient:studentList){%>  
           <tr>  
         
           <td><%=patient.getP_id() %></td>
           <td><%= patient.getP_fname()%></td>  
           <td><%= patient.getP_lname()%></td>  
           <td><a href="StudentServlet?studentIdForEdit=<%=patient.getP_id()%>">Edit</a></td>  
           <td><a href="StudentServlet?studentIdForDelete=<%=patient.getP_id()%>">Delete</a></td>  
           </tr>  
           <%} %>  
           </table>  
</body>
</html>