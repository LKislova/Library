<%--
  Created by IntelliJ IDEA.
  User: Любовь
  Date: 11.12.2014
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AuthorParameters</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<body style="background-color: #C0C0C0;">
<h1>Author</h1>

<h3 align="center">${exeption}</h3>

<h3 align="center">${success}</h3>

<% if (request.getAttribute("author") != null) {%>
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <form action="/AuthorParameters/${author.getId()}/" method="post">
                <p>Full Name
                    <input type="text" name="fullname" required maxlength="60" value="${author.getName()}" size="60">
                </p>

                <p>Birthday
                    <input type="date" name="birthday" required max="2014-12-29" value="${author.formatBirthday()}"
                           size="20">

                <p> Biography<br>
                    <textarea name="biography" maxlength="3000" required rows="20"
                              cols="90">${author.getBiography()}</textarea>
                    <br>
                    <input type="submit" value="EDIT"></p>
                <a href="/main">Return to Mane Menu</a>

            <p>
            </form>
        </div>
    <div class="col-sm-6">
          <p align="right"> Book </p>
              <c:forEach var="book" items="${authorBook}">
                  <tr>
                      <p align="right">
                          <td>
                      <p align="right">
                          <a href="/BookParameters/${book.getId()}/">${book.getName()}</a>
                      </td>
                      <form action="/AuthorParameters/${author.getId()}/book/delete" method="post">
                          <p align="right">
                              <input type="submit" name="deleteBook" value="DELETE">
                              <input type="hidden" name="idBook" value="${book.getId()}">
                      </form>
                  </tr>
              </c:forEach>

              <form action="/AuthorParameters/${author.getId()}/book/add/" method="post">
                  <p align="right">
                      <select name="idNotBook">
                          <c:forEach var="notbook" items="${notBooks}">
                              <option value="${notbook.getId()}">${notbook.getName()}</option>
                          </c:forEach>
                      </select>
                      <input type="submit" name="addBook" value="ADDBOOK">
              </form>
      </div>
  </div>
</div>
<%} else {%>

<form action="/AuthorParameters/" method="post">
  <p>Full Name
      <input type="text" name="fullname" maxlength="60" required value="" size="60">
  </p>

  <p>Birthday
      <input type="date" max="2014-12-29" name="birthday" required value="" size="20"></p>

  <p> Biography<br>
      <textarea name="biography" rows="20" maxlength="3000" required cols="90"></textarea><br>
      <input type="submit" value="Add"></p>
  <a href="/main">Return to Mane Menu</a>
</form>
<%}%>

</body>
</body>
</html>

