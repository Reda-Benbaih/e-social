<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Salary</th><th>Employer ID</th></tr>
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.salary}</td>
                <td>${emp.employerId}</td>
            </tr>
        </c:forEach>
    </table>
    
    <h3>Add New Employee</h3>
    <form action="employees" method="post">
        <input type="text" name="name" placeholder="Name" required>
        <input type="number" name="salary" placeholder="Salary" required>
        <input type="number" name="employerId" placeholder="Employer ID" required>
        <button type="submit">Save</button>
    </form>
</body>
</html>