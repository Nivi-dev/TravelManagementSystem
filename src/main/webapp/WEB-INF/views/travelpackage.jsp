<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/api/admin/tpa" method="post">
    <input type="text" name="title" placeholder="Title" required />
    <input type="text" name="description" placeholder="Description" required />
    <input type="text" name="location" placeholder="Location" required />
    <input type="number" name="duration" placeholder="Duration in Days" required />
    <input type="number" name="price" placeholder="Price" required />
    <input type="number" name="discount" placeholder="Discount %" />
    <input type="number" name="availableSlots" placeholder="Available Slots" />
    <input type="text" name="imageUrl" placeholder="Image URL" />
    <button type="submit">Save Package</button>
</form>
</body>
</html>