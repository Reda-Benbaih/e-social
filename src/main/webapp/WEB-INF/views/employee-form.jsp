<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm w-50 mx-auto">
        <div class="card-header bg-dark text-white">
            <c:if test="${employee != null}">
                <h3 class="mb-0">Edit Employee</h3>
            </c:if>
            <c:if test="${employee == null}">
                <h3 class="mb-0">Add New Employee</h3>
            </c:if>
        </div>
        <div class="card-body">
            <form action="employees" method="post">
                <c:if test="${employee != null}">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>
                <c:if test="${employee == null}">
                    <input type="hidden" name="action" value="insert" />
                </c:if>

                <div class="mb-3">
                    <label class="form-label">Name:</label>
                    <input type="text" class="form-control" name="name" value="<c:out value='${employee.name}' />" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Monthly Salary:</label>
                    <input type="number" step="0.01" class="form-control" name="monthlySalary" value="<c:out value='${employee.monthlySalary}' />" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Employer:</label>
                    <select class="form-select" name="employerId" required>
                        <option value="">Select an Employer...</option>
                        <c:forEach var="emp" items="${listEmployer}">
                            <option value="${emp.id}" 
                                <c:if test="${employee != null && employee.employer.id == emp.id}">selected</c:if>>
                                ${emp.socialReason}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-success w-100">Save</button>
                <a href="employees" class="btn btn-secondary w-100 mt-2">Cancel</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>