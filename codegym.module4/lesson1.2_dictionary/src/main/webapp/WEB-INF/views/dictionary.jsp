<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 14/09/2025
  Time: 3:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<div>
    <form action="/dictionary/search" method="get">
        <input type="text" name="word" id="word" placeholder="Enter a search word">
        <button type="submit" id="search">Search</button>
    </form>
    <div id="result">${word}</div>
</div>
</body>
</html>
