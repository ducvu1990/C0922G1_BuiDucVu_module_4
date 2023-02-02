<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/02/2023
  Time: 3:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Home</h1>
<table>
    <tr>
        <th>#</th>
        <th>Mail</th>
        <th>Settings</th>
    </tr>

        <c:forEach var="setting" items="${settings}" varStatus="id">
            <tr>
                <td>${id.count}</td>
                <td>${setting}</td>
                <td>
                    <button type="button"><a href="/settings?setting=${setting}">Settings</a></button>
                </td>
            </tr>
        </c:forEach>

</table>
</body>
</html>
