<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Statement</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm w-50 mx-auto">
        <div class="card-header bg-dark text-white"><h3>Create Statement Period</h3></div>
        <div class="card-body">
            <form action="statements" method="post">
                <input type="hidden" name="action" value="insert" />
                <div class="mb-3">
                    <label class="form-label">Employer:</label>
                    <select class="form-select" name="employerId" required>
                        <c:forEach var="emp" items="${listEmployer}">
                            <option value="${emp.id}">${emp.socialReason}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Month (1-12):</label>
                        <input type="number" name="month" class="form-control" min="1" max="12" required />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Year:</label>
                        <input type="number" name="year" class="form-control" value="2026" required />
                    </div>
                </div>
                <button type="submit" class="btn btn-primary w-100">Open Period</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>