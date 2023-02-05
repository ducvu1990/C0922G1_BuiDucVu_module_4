<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/02/2023
  Time: 4:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Setting</h1>
<form:form method="post" modelAttribute="settings1" action="update">
    <table>
        <tr hidden>
            <td></td>
            <td><input type="text" value="${setting}" name="email"></td>
        </tr>
        <tr>
            <td>language</td>
            <td><form:select path="language">
                <form:options items="${language}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td><form:select path="pageSize">
                <form:options items="${pageSize}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td>Spams Filter</td>
            <td>Show <form:radiobutton path="signature"></form:radiobutton>Enable Spams Filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
