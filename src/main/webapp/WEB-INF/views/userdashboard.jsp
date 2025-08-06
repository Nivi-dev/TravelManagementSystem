<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="_csrf" value="${_csrf}" />

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>

         <p>Welcome, ${user.name}!</p>
         <p>Email: ${user.email}</p>
   
   <p>You are now in your secure user dashboard.</p>

    <!-- Example content -->
    <ul>
        <li><a href="#">View Profile</a></li>
        <li><a href="#">My Bookings</a></li>
        <li><a href="#">Settings</a></li>
    </ul>

     <%@ include file="headeruserdashboard.jsp" %>

<c:forEach var="pkg" items="${packages}">
    <div class="card" style="width: 18rem; display:inline-block; margin:10px;">
        <img class="card-img-top" src="${pkg.imageUrl}" alt="Package Image" style="height: 200px; object-fit: cover;">
        <div class="card-body">
            <h5 class="card-title">${pkg.title}</h5>
            <p class="card-text">${pkg.description}</p>
            <p>Location: ${pkg.location}</p>
            <p>Duration: ${pkg.duration} days</p>
            <p>Price: ₹${pkg.price}</p>
            <form action="${pageContext.request.contextPath}/user/book" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="hidden" name="packageId" value="${pkg.packageId}" />
                <button type="submit" class="btn btn-primary">Book Trip</button>
            </form>
        </div>
    </div>
</c:forEach>


<%@ include file="footeruserdashboard.jsp" %>
     
     
     
    
   
</body>
</html>
