<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Employers</title>
</head>
<body>
    <h1>Employer List</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Social Reason</th>
                <th>Activity</th>
            </tr>
        </thead>
        <tbody>
            <%-- This loop iterates over the 'employers' list from the Servlet --%>
            <c:forEach items="${employers}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.socialReason}</td>
                    <td>${emp.activity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <hr>
    <h3>Add New Employer</h3>
    <form action="employers" method="post">
        <input type="text" name="socialReason" placeholder="Social Reason" required>
        <input type="text" name="activity" placeholder="Activity" required>
        <button type="submit">Save Employer</button>
    </form>
</body>
</html>