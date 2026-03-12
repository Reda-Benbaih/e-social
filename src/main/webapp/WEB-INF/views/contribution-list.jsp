<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contribution Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-warning text-dark d-flex justify-content-between align-items-center">
            <h2 class="mb-0">Payroll Contributions</h2>
            <a href="contributions?action=new" class="btn btn-dark">New Declaration</a>
        </div>
        <div class="card-body">
            <table class="table table-striped align-middle">
                <thead>
                    <tr>
                        <th>Employee</th>
                        <th>Period (Month/Year)</th>
                        <th>Employee (5%)</th>
                        <th>Employer (10%)</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="con" items="${listContribution}">
                        <tr>
                            <td><strong>${con.employee.name}</strong></td>
                            <td>${con.statement.month} / ${con.statement.year}</td>
                            <td class="text-danger">-${con.employeeContribution}</td>
                            <td class="text-primary">+${con.employerContribution}</td>
                            <td>
                                <a href="contributions?action=delete&id=${con.id}" 
                                   class="btn btn-sm btn-outline-danger" 
                                   onclick="return confirm('Delete this record?');">Remove</a>
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