<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${docters}" var="docter">
                <tr>
                    <td><c:out value="${docter.d_id}" /></td>
                    <td><c:out value="${docter.d_fname}" /></td>
                    <td><c:out value="${docter.d_lname}" /></td>
                    <!--<fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}" /></td> -->
                      <td><td><c:out value="${docter.d_email}" /></td>
                    <td><a href="UserController?action=edit&userId=<c:out value="${docter.userid}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${docter.userid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>