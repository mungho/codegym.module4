<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<div>
    <h1>Calculator</h1>
    <form action="/calculator" method="get">
        <div>
            <input type="number" name="number1" id="number1" placeholder="Enter the first number">
            <input type="number" name="number2" id="number2" placeholder="Enter the second number">
        </div>
        <div style="margin-top: 20px">
            <button type="submit" name="operation" value="+">Addition (+)</button>
            <button type="submit" name="operation" value="-">Subtraction (-)</button>
            <button type="submit" name="operation" value="*">Multiplication (x)</button>
            <button type="submit" name="operation" value="/">Division (/)</button>
        </div>
    </form>
    <div>
        <c:if test = "${not empty result}">
            <p>Result is: ${result}</p>
        </c:if>
    </div>
</div>
</body>
</html>
