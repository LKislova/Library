<%--
  Created by IntelliJ IDEA.
  User: Любовь
  Date: 11.12.2014
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookParameters</title>
</head>
<body>
<body bgcolor="C0C0C0">
<h1>Book</h1>

<h3 align="center">${exeption}</h3>

<h3 align="center">${success}</h3>
<% if (request.getAttribute("book") != null) {%>
<form action="BookParameters/${book.id}" method="post">
    <p>Name
        <input type="text" name="name" maxlength="60" required value="${book.name}" size="60">
    </p>

    <p>Publish Date
        <input type="number" name="publishDate" max="2014" min="1" required value="${book.publishDate}" size="20">

    <p> Style
        <input type="text" name="style" maxlength="60" required value="${book.style}" size="60"></p>

    <p>Author:
        ${book.booksAuthor.name}<br>

        <input type="submit" name="Edit" value="UPDATE"></p>

    <a href="/main">Return to Mane Menu</a>
</form>
<p>
    <%} else {%>

<form action="BookParameters/" method="post">
    <p>Name
        <input type="text" name="name" maxlength="50" required value="" size="60">
    </p>

    <p>Publish Date
        <input type="number" max="2014" min="1" required name="publishDate" value="" size="20"></p>

    <p> Style
        <input type="text" max="50" name="style" required value="" size="60">
        <input type="submit" name="Edit" value="UPDATE"></p>
    <a href="/main">Return to Mane Menu</a>
</form>
<%}%>

</body>
</body>
</html>
