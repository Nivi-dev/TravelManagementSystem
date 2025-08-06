<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Login</title>
  <link rel="stylesheet" href="/css/style.css">
  <style>
    .error { color: red; margin-bottom: 10px; }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>Admin Login</h2>

    <!-- Error message -->
    <div id="errorMsg" class="error" style="display: none;">Invalid username or password.</div>

    <form action="${pageContext.request.contextPath}/admin/perform_login" method="post">
      <input type="text" name="username" placeholder="Enter username" required>
      <input type="password" name="password" placeholder="Enter password" required>
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <button type="submit">Login</button>
    </form>
  </div>

  <script>
    // Show error message if error=true in URL
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get("error") === "true") {
      document.getElementById("errorMsg").style.display = "block";
    }
  </script>
</body>
</html>
    