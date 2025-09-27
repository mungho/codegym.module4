<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<div>
    <h3>Your Sandwich Including:</h3>
    <c:if test="${empty condiments}">
        <p>You haven't selected condiments yet</p>
    </c:if>
    <ul>
        <c:if test="${not empty condiments}">
            <c:forEach items="${condiments}" var="condiment">
                <li>${condiment}</li>
            </c:forEach>
        </c:if>

    </ul>
</div>
</body>
</html>
