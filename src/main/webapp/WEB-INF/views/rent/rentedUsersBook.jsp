<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>rented Books</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>Rented BOOKS</h1>
<div alighn="center">
    <h2>Books rented by user ${user.firstName} ${user.lastName} with id = ${user.userId} </h2>
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
                <td>
                    <a href="${pageContext.request.contextPath}/rent/rentBook?bookId=${book.bookId}">rent</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/rent/return?bookId=${book.bookId}">return</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
