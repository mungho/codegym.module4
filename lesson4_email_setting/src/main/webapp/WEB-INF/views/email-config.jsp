<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
</head>
<body>
<div>
    <form:form action="${pageContext.request.contextPath}/email-config" method="post" modelAttribute="emailConfig">
        <table>
            <tr>
                <td>Language:</td>
                <td>
                    <form:input path="language"></form:input>
                </td>
            </tr>
            <tr>
                <td>Page Size:</td>
                <td>
                    <span>Show </span>
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100">100</form:option>
                    </form:select>
                    <span> emails per page</span>
                </td>
            </tr>
            <tr>
                <td>Spams filter:</td>
                <td>
                    <form:checkbox path="emailEnabled" id="emailEnabled"/>
                    <label for="emailEnabled">Enabled spams filter</label>
                </td>
            </tr>
            <tr>
                <td>Signature:</td>
                <td>
                    <form:textarea path="signature"></form:textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <form:button>Update</form:button>
                </td>
                <td>
                    <button type="button">Cancel</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
