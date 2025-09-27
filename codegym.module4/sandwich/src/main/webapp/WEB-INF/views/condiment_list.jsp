<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/09/2025
  Time: 8:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<div>
    <form action="/sandwich/condiments/selected" method="get">
        <h1>Sandwich Condiments</h1>
        <input type="checkbox" name="condiments" value="Cheese">
        <label>Cheese</label>
        <input type="checkbox" name="condiments" value="Mayonnaise">
        <label>Mayonnaise</label>
        <input type="checkbox" name="condiments" value="Mustard">
        <label>Mustard</label>
        <input type="checkbox" name="condiments" value="Pickles">
        <label>Pickles</label>
        <input type="checkbox" name="condiments" value="Onions">
        <label>Onions</label>
        <input type="checkbox" name="condiments" value="Tomatoes">
        <label>Tomatoes</label>
        <input type="checkbox" name="condiments" value="Lettuce">
        <label>Lettuce</label>
        <div style="margin-top: 20px">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
