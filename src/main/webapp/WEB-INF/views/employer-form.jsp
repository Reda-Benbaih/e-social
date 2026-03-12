<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employer Setup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm w-50 mx-auto">
        <div class="card-header bg-dark text-white">
            <h3 class="mb-0">${employer != null ? 'Update Employer' : 'Register Employer'}</h3>
        </div>
        <div class="card-body">
            <form action="employers" method="post">
                <input type="hidden" name="action" value="${employer != null ? 'update' : 'insert'}" />
                <c:if test="${employer != null}">
                    <input type="hidden" name="id" value="${employer.id}" />
                </c:if>

                <div class="mb-3">
                    <label class="form-label font-weight-bold">Social Reason (Company Name):</label>
                    <input type="text" class="form-control" name="socialReason" value="<c:out value='${employer.socialReason}' />" required />
                </div>

                <div class="mb-3">
                    <label class="form-label font-weight-bold">Activity / Industry:</label>
                    <input type="text" class="form-control" name="activity" value="<c:out value='${employer.activity}' />" required />
                </div>

                <div class="row g-2">
                    <div class="col-md-6">
                        <button type="submit" class="btn btn-success w-100">Save Employer</button>
                    </div>
                    <div class="col-md-6">
                        <a href="employers" class="btn btn-secondary w-100">Cancel</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>