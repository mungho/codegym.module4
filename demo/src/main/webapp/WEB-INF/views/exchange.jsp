<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/09/2025
  Time: 8:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/exchange" method="post">
        <input name="usd" type="number" placeholder="Enter the USD amount">
        <button type="submit">Exchange</button>
    </form>
    <div>
        <p>${vnd}</p>
    </div>
</div>
</body>
</html>
