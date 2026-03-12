<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row mb-3">
        <div class="col-md-8">
            <h2>Employee List</h2>
        </div>
        <div class="col-md-4 text-end">
            <a href="employees?action=new" class="btn btn-success">Add New Employee</a>
        </div>
    </div>
    
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Monthly Salary</th>
                <th>Employer</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="emp" items="${listEmployee}">
                <tr>
                    <td><c:out value="${emp.id}" /></td>
                    <td><c:out value="${emp.name}" /></td>
                    <td>$<c:out value="${emp.monthlySalary}" /></td>
                    <td><c:out value="${emp.employer.socialReason}" /></td>
                    <td>
                        <a href="employees?action=edit&id=<c:out value='${emp.id}' />" class="btn btn-sm btn-primary">Edit</a>
                        <a href="employees?action=delete&id=<c:out value='${emp.id}' />" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>