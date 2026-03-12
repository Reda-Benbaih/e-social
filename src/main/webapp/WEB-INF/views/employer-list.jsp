<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employer Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h2 class="mb-0">Employer Directory</h2>
            <a href="employers?action=new" class="btn btn-light text-primary">Add New Employer</a>
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead class="table-light">
                    <tr>
                        <th>ID</th>
                        <th>Social Reason</th>
                        <th>Activity Domain</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employer" items="${listEmployer}">
                        <tr>
                            <td><c:out value="${employer.id}" /></td>
                            <td><c:out value="${employer.socialReason}" /></td>
                            <td><c:out value="${employer.activity}" /></td>
                            <td>
                                <a href="employers?action=edit&id=${employer.id}" class="btn btn-sm btn-outline-primary">Edit</a>
                                <a href="employers?action=delete&id=${employer.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Deleting an employer may affect related employees and statements. Proceed?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>