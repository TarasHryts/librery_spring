<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/book/all">info</a>
<a href="${pageContext.request.contextPath}/book/add">add book</a>
<a href="${pageContext.request.contextPath}/logout">Log OUT</a>
<form action="${pageContext.request.contextPath}/book/find" method="get">
    <td>Book title:</td>
    <td><input value="${title}" name="title"/></td>
    <button type="submit"> Find</button>
</form>
</body>
</html>
