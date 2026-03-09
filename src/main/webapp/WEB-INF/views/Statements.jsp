<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Monthly Statements</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f4f4f4; }
        .form-container { background: #f9f9f9; padding: 15px; border: 1px solid #ccc; width: 300px; }
        input, select { display: block; margin-bottom: 10px; width: 100%; }
    </style>
</head>
<body>

    <h2>Monthly Statements List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Employer</th>
                <th>Month</th>
                <th>Year</th>
                <th>Declaration Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${statements}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.employer.socialReason}</td>
                    <td>${s.month}</td>
                    <td>${s.year}</td>
                    <td>${s.statementDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="form-container">
        <h3>Create New Statement</h3>
        <form action="statements" method="post">
            <label>Employer ID:</label>
            <input type="number" name="employerId" required placeholder="Enter Employer ID">
            
            <label>Month:</label>
            <select name="month" required>
                <option value="1">January</option>
                <option value="2">February</option>
                <option value="3">March</option>
                <option value="4">April</option>
                <option value="5">May</option>
                <option value="6">June</option>
                <option value="7">July</option>
                <option value="8">August</option>
                <option value="9">September</option>
                <option value="10">October</option>
                <option value="11">November</option>
                <option value="12">December</option>
            </select>
            
            <label>Year:</label>
            <input type="number" name="year" value="2026" required>
            
            <button type="submit">Add Statement</button>
        </form>
    </div>

    <p><a href="index.jsp">Back to Home</a></p>

</body>
</html>