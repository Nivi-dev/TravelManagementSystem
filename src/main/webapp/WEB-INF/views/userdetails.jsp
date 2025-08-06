<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: right; margin: 20px;">
    <a href="/admin/add-user">
        <button style="padding: 8px 16px; background-color: #28a745; color: white; border: none; border-radius: 4px;">
             Add New User
        </button>
    </a>
</div>
<div style="text-align: left; margin: 20px;">
    <a href="/admin/dashboard">
        <button style="padding: 8px 16px; background-color: blue; color: white; border: none; border-radius: 4px;">
        Back to Dashboard</button>
    </a>
</div>

<center >
 <table border="1" cellpadding="10" >
 <caption style="font-weight: bold;">User Deatils</caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Username</th>
        <th>Password</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    <c:forEach var="us" items="${users}">
        <tr>
            <td>${us.id}</td>
            <td>${us.name}</td>
            <td>${us.email}</td>
            <td>${us.username}</td>
            <td>${us.password}</td>
            <td>${us.phone}</td>
            <td>${us.address}</td>
            <td>  
                <a href="/admin/editPackage/${us.id}">Edit</a> |
                <a href="/admin/deletePackage/${us.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</center>

</body>
</html>