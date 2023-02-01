<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/02/2023
  Time: 3:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Dictionary App</h1>
<form action="/translate" method="post">
    <input type="text" name="english"><input type="submit" value="Dịch"><br>
    <p>${map}</p>
</form>
</body>
</html>
