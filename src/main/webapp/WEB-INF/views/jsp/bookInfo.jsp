
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <spring:url value="/addToCart" var="addToCart" />

<sf:form class="form-horizontal" action="${addToCart}" role="form" method="post">

    <h2 class="text-success">${book.title}</h2>
    <h4 class="text-info">By ${book.author}</h4>
    <h4 class="text-warning">Published by ${book.publisher}</h4>
    <h4 class="text-danger">Price:$${book.price}</h4>
    <h4 class="text-info">Pages:${book.pages}</h4>
    <h4 class="text-primary">${book.description}</h4>

    <br/>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <button type="submit" class="btn btn-primary">ADD TO CART</button>
        </div>
    </div>
</sf:form>

</div>

</body>
</html>
