<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/admin/reset-password" method="post">
    <label>New Password:</label>
    <input type="password" name="newPassword" required>
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Reset Password</button>
</form>

</body>
</html>