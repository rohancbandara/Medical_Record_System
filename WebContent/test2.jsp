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
 <%@ page import="java.sql.*" %>
    <%
            Class.forName ("com.mysql.jdbc.Driver");            
            Connection  conn=null;  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sliate_project","root","kaththa");
            ListPatient ListPatient=new ListPatient();
            ListPatient.listAllPatient();
            
            %>
 <center>
        <h1>Books Management</h1>
        <h2>
            <a href="/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Books</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>FNAME</th>
            </tr>
            
            <c:forEach var="patient" items="${listPatient}">
                <tr>
                    <td><c:out value="${patient.id}" /></td>
                    <td><c:out value="${patient.fname}" /></td>
                   
                    <td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>