<%--
  Created by IntelliJ IDEA.
  User: Любовь
  Date: 11.12.2014
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author.com</title>
</head>
<body>
<body bgcolor="C0C0C0">

<h1>Authors:</h1>
<h3 align="center">${success}</h3>
<br> <br>
<table>
    <c:forEach var="author" items="${listAuthor}">
        <tr>
            <td><a href="AuthorParameters/${author.id}/">${author.name}</a></td>
        </tr>
    </c:forEach>
</table>
<form action="AuthorParameters">
    <input type="submit" value="ADD">
</form>
</body>
</body>
</html>
