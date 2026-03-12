<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Contribution</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm w-50 mx-auto">
        <div class="card-header bg-dark text-white text-center">
            <h3 class="mb-0">Declare Monthly Contribution</h3>
        </div>
        <div class="card-body p-4">
            <form action="contributions" method="post">
                <input type="hidden" name="action" value="insert" />

                <div class="mb-4">
                    <label class="form-label fw-bold">Select Employee:</label>
                    <select class="form-select" name="employeeId" required>
                        <c:forEach var="emp" items="${listEmployee}">
                            <option value="${emp.id}">${emp.name} (Salary: ${emp.monthlySalary})</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-4">
                    <label class="form-label fw-bold">Select Statement Period:</label>
                    <select class="form-select" name="statementId" required>
                        <c:forEach var="st" items="${listStatement}">
                            <option value="${st.id}">${st.month}/${st.year} - ${st.employer.socialReason}</option>
                        </c:forEach>
                    </select>
                    <div class="form-text">Note: Rates are 5% Employee and 10% Employer.</div>
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary">Calculate & Save</button>
                    <a href="contributions" class="btn btn-outline-secondary">Back to List</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>