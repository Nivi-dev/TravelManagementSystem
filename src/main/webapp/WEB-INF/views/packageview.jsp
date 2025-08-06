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
    <a href="/admin/new-package">
        <button style="padding: 8px 16px; background-color: #28a745; color: white; border: none; border-radius: 4px;">
             Add New Package
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
 <caption style="font-weight: bold;">Package Details</caption>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Location</th>
        <th>Price</th>
        <th>Duration</th>
        <th>Discount</th>
        <th>Available Slots</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="pkg" items="${packages}">
        <tr>
            <td>${pkg.packageId}</td>
            <td>${pkg.title}</td>
            <td>${pkg.description}</td>
            <td>${pkg.location}</td>
            <td>₹${pkg.price}</td>
            <td>${pkg.duration}</td>
            <td>${pkg.discount}%</td>
            <td>${pkg.availableSlots}</td>
            <td>  
                <a href="/admin/editPackage/${pkg.packageId}">Edit</a> |
                <a href="/admin/deletePackage/${pkg.packageId}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</center>

</body>
</html>