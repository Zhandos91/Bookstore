
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
    <spring:url value="/resources/images" var="images" />
<sf:form class="form-horizontal" action="${addToCart}" role="form" method="post">

    <h2 class="text-success" align="center">${book.title}</h2>
    <img src="${images}/${book.title}.jpg" class="img-thumbnail" alt=${book.title} width="304" height="236">
    <h4 class="text-info col-xs-offset-1"><spring:message code="book.author" /> ${book.author}</h4>
    <h4 class="text-warning col-xs-offset-1"><spring:message code="book.publisher" /> ${book.publisher}</h4>
    <h4 class="text-danger col-xs-offset-1"><spring:message code="book.price" />:$${book.price}</h4>
    <h4 class="text-info col-xs-offset-1"><spring:message code="book.pages" />:${book.pages}</h4>
    <h4 class="text-primary">${book.description}</h4>

    <br/>
    <div class="form-group">
        <div class="col-xs-offset-1">
            <button type="submit" class="btn btn-primary"><spring:message code="book.button.addToCart" /></button>
        </div>
    </div>
</sf:form>

</div>

</body>
</html>
