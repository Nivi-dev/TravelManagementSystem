<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking History</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Booking History</h2>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Booking ID</th>
            <th>Booking Date</th>
            <th>Username</th>
            <th>Travel Package Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="booking" items="${bookings}">
            <tr>
                <td>${booking.bookingId}</td>
                <td>${booking.bookingDate}</td>
                <td>${booking.user.username}</td>
                <td>${booking.travelPackage.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div style="text-align: left; margin: 20px;">
    <a href="/admin/dashboard">
        <button style="padding: 8px 16px; background-color: blue; color: white; border: none; border-radius: 4px;">
        Back to Dashboard</button>
    </a>
</div>
</body>
</html>
