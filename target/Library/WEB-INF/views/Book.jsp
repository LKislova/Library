<%--
  Created by IntelliJ IDEA.
  User: Любовь
  Date: 11.12.2014
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu.com</title>
</head>
<body>
<body bgcolor="C0C0C0">
<h1>Books:</h1>

<h3 align="center">${exeption}</h3>

<h3 align="center">${success}</h3>
<br><br>
<table>

    <c:forEach var="book" items="${listBook}">
        <tr>
            <td><a href="BookParameters/${book.id}">${book.name}</a></td>
        </tr>
    </c:forEach>

</table>
<form action="BookParameters">
    <input type="submit" value="ADD">
</form>

</body>
</body>
</html>

