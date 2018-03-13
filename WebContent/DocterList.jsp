<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<%@page import="com.rcb.model.Docter"%>
<html>
<head>
	<title>Docter List</title>
</head>
<body>
<% if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
}

%>
<h3>Welcome :${username }        <a href="login">logout</a></h3>




	<form action="AddDocter.jsp" method="get">
		<label>Patient:</label>
		<input type="text" name="patient" id="patient">
		<input type="submit" name="btnSearch" id="btnAddNewPatient" value="Add New Docter" >

		<table border="1">
				<th scope="col">DID</th><th scope="col">Docter Name</th><th scope="col">Date of Birth</th><th scope="col">Email</th><th scope="col">Special</th><th scope="col">Created Date</th><th colspan="2" scope="col">Action</th>
				<%
					Docter docter=new Docter();
					DbConnection db=new DbConnection();
					int id;
					String d_fname,d_lname,d_dob,d_email,d_special,create_date;
					try
					{
						String sql="SELECT * FROM tbl_docters";
						ResultSet rs=db.getData(sql);
						while(rs.next()){
							id=rs.getInt("d_id");
							d_fname=rs.getString("d_fname");
							d_lname=rs.getString("d_lname");
							d_dob=rs.getString("d_dob");
							d_email=rs.getString("d_email");
							d_special=rs.getString("d_special");
							create_date=rs.getString("create_date");
							%>
							
							<tr>
								<td><%=id %></td>
								<td><%=d_fname %> <%=d_lname %></td>
								<td><%=d_dob %></td>
								<td><%=d_email %></td>
								<td><%=d_special %></td>
								<td><%=create_date %></td>
								<td><a href="/Medicle_Record_System/docterEdit?id=<%=id %>">Edit</a></td>
								<td><a href="/Medicle_Record_System/docterDelete?id=<%=id %>">Delete</a></td>
								
								
							
							</tr>
							
							
							<%
							}
					}catch(Exception e)
					{
						e.printStackTrace();
						}
				
				%>
				
		

		</table>


	</form>


</body>
</html>