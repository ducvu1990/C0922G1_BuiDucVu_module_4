<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/02/2023
  Time: 4:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Personal computer</h1>
<form action="/calculate" method="post">
    <table>
        <tr>
            <td><input type="number" name="numberOne" value="0"></td>
            <td><input type="submit" name="calculation" value="+"></td>
            <td><input type="submit" name="calculation" value="-"></td>
        </tr>
        <tr>
            <td><input type="number" name="numberTwo" value="0"></td>
            <td><input type="submit" name="calculation" value="*"></td>
            <td><input type="submit" name="calculation" value="/"></td>
        </tr>
    </table>
    <p>Result: ${result}</p>
</form>
</body>
</html>
