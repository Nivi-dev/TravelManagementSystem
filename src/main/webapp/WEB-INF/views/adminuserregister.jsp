<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/api/admin/add-new-user" method="post">
      <input type="text" name="name" placeholder="Enter the name" required>
      <input type="text" name="username" placeholder="Enter username" required>
      <input type="email" name="email" placeholder="Enter email" required>
      <input type="Tel" name="phone" placeholder="Enter Mobile Number" required>
      <input type="password" name="password" placeholder="Enter password" required>
      <input type="text" name="address" placeholder="Enter address" required>
      
      <button type="submit">Register</button>
    </form>
</body>
</html>