<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/02/2023
  Time: 2:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Currency converter app</h1>
<form action="/currency-converter" method="post">
  <table>
    <tr>
      <td><input type="number" name="usd"></td>
      <td><input type="number" name="rate"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Chuyển Đổi"></td>
    </tr>
    <tr>
      <td>${vnd}</td>
      <td>vnd</td>
    </tr>
  </table>
</form>
</body>
</html>
