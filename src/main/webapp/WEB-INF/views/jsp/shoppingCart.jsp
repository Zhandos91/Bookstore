
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <spring:url value="/removeBookFromCart" var="removeBook" />

    <div class="page-header"><h1>Your Cart</h1></div>

    <sf:form class="form-horizontal">

    <c:forEach items="${shoppingCart}" var="book" >

        <h2>
        <div class="form-group" >
            <label class="control-label col-xs-offset-7 col-xs-2">Quantity</label>
            <label class="control-label col-xs-2">Price</label>
        </div>
        <div class="form-group" >
            <label class="control-label col-xs-7">
            <a href="${pageContext.request.contextPath}/${book.id}">
                ${book.title} By ${book.author} $${book.price}
            </a>
            </label>
            <label class="control-label col-xs-2">4</label>
            <label class="control-label col-xs-2">35.77</label>

           <a class="btn btn-primary" href="${pageContext.request.contextPath}/remove/${book.id}" >REMOVE</a>

        </div>
        </h2>

    </c:forEach>


    </sf:form>

</div>
</body>
</html>
