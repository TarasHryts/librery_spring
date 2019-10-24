<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find book</title>
</head>
<body>
<h1>find book</h1>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All Books</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>Hello from All books page</h1>
<div alighn="center">
    <h2>Select what you want to buy </h2>
    <form action="${pageContext.request.contextPath}/book/add" method="post">
        <table>
            <tr>
                <td>Book title:</td>
                <td><input value="${title}" name="title"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Confirm</button>
                </td>
            </tr>
        </table>
    </form>

    <table border="2">
        <tr>
            <th>Info</th>
            <th>Title</th>
            <th>Year</th>
            <th>Price</th>
            <th>Authors</th>
        </tr>
        <c:forEach var="book" items="${allBooks}">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>${book.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book/${book.bookId}">details....</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
