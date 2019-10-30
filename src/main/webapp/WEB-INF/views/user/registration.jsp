<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create book</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/user/registration" method="post">
    <table>
        <tr>
            <td>First Name</td>
            <td><input value="${firstName}" name="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input value="${lastName}" name="lastName"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input value="${email}" name="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" value="${password}" name="password"/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" value="${confirmPassword}" name="confirmPassword"/></td>
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
