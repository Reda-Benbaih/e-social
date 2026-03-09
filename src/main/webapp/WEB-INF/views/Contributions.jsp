<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Employee Contributions</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Employee Name</th>
            <th>Month/Year</th>
            <th>Employee Share</th>
            <th>Employer Share</th>
        </tr>
        <c:forEach items="${contributions}" var="con">
            <tr>
                <td>${con.id}</td>
                <td>${con.employee.name}</td>
                <td>${con.statement.month} / ${con.statement.year}</td>
                <td>${con.employeeContribution}</td>
                <td>${con.employerContribution}</td>
            </tr>
        </c:forEach>
    </table>

    <hr>
    <h3>Add New Contribution</h3>
    <form action="contributions" method="post">
        <input type="number" name="employeeId" placeholder="Employee ID" required>
        <input type="number" name="statementId" placeholder="Statement ID" required>
        <input type="number" step="0.01" name="employeeContribution" placeholder="Employee Part" required>
        <input type="number" step="0.01" name="employerContribution" placeholder="Employer Part" required>
        <button type="submit">Submit Declaration</button>
    </form>
</body>
</html>