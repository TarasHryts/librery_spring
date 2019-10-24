<%--
  Created by IntelliJ IDEA.
  User: Тарас
  Date: 24.10.2019
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create book</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/add" method="post">
    <table>
        <tr>
            <td>Book title:</td>
            <td><input value="${title}" name="title"/></td>
        </tr>
        <tr>
            <td>Year:</td>
            <td><input value="${year}" name="year"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input value="${price}" name="price"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Confirm</button>
                <br>
                <br>
                <a href="${pageContext.request.contextPath}/book/all">all books</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
