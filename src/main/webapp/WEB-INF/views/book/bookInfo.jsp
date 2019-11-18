<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
 <head>
    <title>${book.title}</title>
 </head>
 <body>
 <jsp:include page="../header.jsp"/>
 <h2>${book.title}</h2><br/>
  <b>Publication date: </b>${book.year} <br/>
    <c:forEach var="author" items="${book.authors}">
      <b>Author: </b>${author.name} ${author.surname} <br/>
    </c:forEach>
  <b>Price: </b>${book.price}<br/>
 </body>
</html>
