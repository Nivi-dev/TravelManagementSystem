<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New User</title>
</head>
<body>
   <c:set var="_csrf" value="${_csrf}" />
    <!-- Error block -->
    <c:if test="${not empty error}">
        <p style="color:red;">
            <c:choose>
                <c:when test="${error == 'username'}">Username already exists.</c:when>
                <c:when test="${error == 'email'}">Email already registered.</c:when>
                <c:when test="${error == 'mobile'}">Mobile number already registered.</c:when>
                <c:otherwise>An unknown error occurred.</c:otherwise>
            </c:choose>
        </p>
    </c:if>

    <!-- Success block -->
    <c:if test="${not empty success}">
        <p style="color:green;">${success}</p>
        <span>Successfully Registered...Click Login</span>
    </c:if>

    <!-- Registration form -->
    <form action="${pageContext.request.contextPath}/user/register" method="post" onsubmit="console.log('Form submitted')">
        <input type="text" name="name" placeholder="Name" required /><br>
        <input type="text" name="username" placeholder="Username" required /><br>
        <input type="email" name="email" placeholder="Email" required /><br>
        <input type="text" name="phone" placeholder="Phone" required /><br>
        <input type="password" name="password" placeholder="Password" required /><br>
        <input type="text" name="address" placeholder="Address" required /><br>
        <button type="submit">Register</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        
    </form>

    <!-- Link to login -->
    <p>Already have an account? <a href="${pageContext.request.contextPath}/user/login">Login here</a></p>

</body>
</html>
