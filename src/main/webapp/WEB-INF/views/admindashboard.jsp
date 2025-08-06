<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-5">
    <h2 class="text-center mb-4">Admin Dashboard</h2>

    <div class="row g-4">
      <div class="col-md-4">
        <div class="card shadow">
          <div class="card-body">
            <h5 class="card-title">Manage Users</h5>
            <p class="card-text">View or manage all registered users.</p>
            <a href="/admin/view-user" class="btn btn-primary">View Users</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="card shadow">
          <div class="card-body">
            <h5 class="card-title">Manage Trips</h5>
            <p class="card-text">Add, edit or delete travel trips.</p>
            <a href="/admin/packages" class="btn btn-success">Manage Trips</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="card shadow">
          <div class="card-body">
            <h5 class="card-title">Bookings</h5>
            <p class="card-text">View booking history and details.</p>
            <a href="/admin/bookings" class="btn btn-info">View Bookings</a>
          </div>
        </div>
      </div>
    </div>

    <div class="text-center mt-5">
      <form action="${pageContext.request.contextPath}/admin/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit">Logout</button>
    </div>
  </div>

</body>
</html>
