<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <spring:url value="/shipping" var="checkout"/>

    <div style="align-content: center" class="text-danger"><h1>Your Cart</h1></div>

    <sf:form class="form-horizontal" action="${checkout}" method="get">

        <c:set var="total" value="${0}"/>

        <h3>
        <div class="form-group">
            <label class="text-primary control-label col-xs-offset-7 col-xs-2">Quantity</label>
            <label class="text-primary control-label col-xs-2">Price</label>
        </div>
        <c:forEach items="${shoppingCart}" var="book">



            <div class="form-group" style="background-color: yellowgreen">
                <label class="control-label col-xs-7">
                    <a href="${pageContext.request.contextPath}/${book.key.id}">
                            ${book.key.title} By ${book.key.author} $${book.key.price}
                    </a>
                </label>
                <label class="control-label col-xs-2">${book.value}</label>

               <c:set var="subtotal" > <c:out value="${book.value * book.key.price}"/></c:set>

                <label class="control-label col-xs-2">$<fmt:formatNumber type="number" maxFractionDigits="2" value="${subtotal}" /> </label>

                <c:set var="total" value="${total + book.value * book.key.price}"/>

                <a class="btn btn-primary" href="${pageContext.request.contextPath}/remove/${book.key.id}">REMOVE</a>

            </div>
        </c:forEach>


        <div class="form-group">
            <label class="text-danger control-label col-xs-offset-7 col-xs-2">Total Price</label>
            <label class="text-danger control-label col-xs-2">$<fmt:formatNumber type="number"
                                                                                                   maxFractionDigits="2"
                                                                                                   value="${total}"/></label>
        </div>
        </h3>

        <br/><br/>
        <br/><br/>
        
        <div class="form-group">
            <h3>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/listBooks">CONTINUE SHOPPING</a>
            <button style="float: right;" type="submit" class="col-xs-offset-2 btn btn-primary">CHECKOUT</button>
            </h3>
        </div>


    </sf:form>

</div>
</body>
</html>
