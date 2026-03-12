<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Statement Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-info text-white d-flex justify-content-between align-items-center">
            <h2 class="mb-0">Monthly Statements</h2>
            <a href="statements?action=new" class="btn btn-light">Create New Period</a>
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Employer</th>
                        <th>Period (MM/YYYY)</th>
                        <th>Submission Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="st" items="${listStatement}">
                        <tr>
                            <td>${st.id}</td>
                            <td>${st.employer.socialReason}</td>
                            <td>${st.month} / ${st.year}</td>
                            <td>${st.statementDate}</td>
                            <td>
                                <a href="statements?action=delete&id=${st.id}" class="btn btn-sm btn-danger" onclick="return confirm('Delete this period?');">Delete</a>
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