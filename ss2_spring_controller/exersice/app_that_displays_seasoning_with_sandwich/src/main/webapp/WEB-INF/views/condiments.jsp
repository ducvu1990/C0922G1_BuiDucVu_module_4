<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/02/2023
  Time: 3:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="condiment" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts<br>
    <hr>
    <input type="submit" value="save">
</form>
<c:forEach items='${condiments}' var="condiment">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
