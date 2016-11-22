
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="page-header"><label><h3>Hello, ${customer.first_name} ${customer.last_name}!</h3></label></div>


<h3 class="bg-danger">A list of books:</h3>

<c:forEach items="${bookList}" var="book">

    <a href="${pageContext.request.contextPath}/BookInfo">
        <h3>${book.title}</h3>
        <h3>By ${book.author}</h3>
        <h3>$${book.price}</h3>
    </a>
    <br/>
    <br/>

</c:forEach>


</body>
</html>
