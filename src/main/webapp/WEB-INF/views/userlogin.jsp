<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>

    <form action="${pageContext.request.contextPath}/user/perform_login" method="post">
    <input type="text" name="username" />
    <input type="password" name="password" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Login</button>
</form>
    

        <!-- Error message -->
        <c:if test="${param.error eq 'true'}">
            <p style="color:red;">Invalid username or password</p>
        </c:if>

        <!-- Logout message -->
        <c:if test="${param.logout != null}">
             <p style="color: green;">You have been logged out successfully!</p>
        </c:if>
        

    </form>

    <p>Don't have an account? <a href="${pageContext.request.contextPath}/user/register">Register here</a></p>
</body>
</html>
