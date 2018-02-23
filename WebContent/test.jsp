<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>testing</title>
</head>
<body>
 <%@ page import="java.sql.*" %>
    <%
            Class.forName ("com.mysql.jdbc.Driver");            
            Connection  conn=null;  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sliate_project","root","kaththa");
            %>
    <body>
    <center>
        <h1>USERS TABLE</h1>
        <form action="delete" method="post">
         <table>
            <tr>
                <th>UserId</th>
                <th>Username</th>
            </tr>
        <%
            Statement stm = conn.createStatement();
            String s = "SELECT * FROM tbl_patient";
            ResultSet r = stm.executeQuery(s);
           
            
            while ( r.next() )
             { 
                 out.print("<tr>");
                 out.print("<td>" +  r.getString ("p_id") + "</td>" ); 
                 
                 out.print("<td>" +  r.getString ("p_fname") + "</td>");
                
                 out.print("<td>"+"<input type='submit' value='Delete' name='"+r.getString("p_id")+"'/>"+"</td>");
                 out.print("</tr>");
             }
           
         %>     
        </table>
        
        </form>
       
    </center>
    </body>
</body>
</html>