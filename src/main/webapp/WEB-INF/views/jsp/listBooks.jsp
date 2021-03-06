<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container" >
<div class="page-header"><h2 class="text-danger"><spring:message code="home.text.hello" />, ${customer.first_name} ${customer.last_name}!</h2></div>


<h3 class="text-success" align="center"><spring:message code="home.text.list" /></h3>
    <spring:url value="/resources/images" var="images" />

<c:forEach items="${bookList}" var="book">

    <a class="text-center" href="${pageContext.request.contextPath}/${book.id}">
        <img class="img-responsive center-block" src="${images}/${book.title}.jpg" class="img-thumbnail" alt=${book.title} width="304" height="236">
        <h3>${book.title}</h3>
        <h3>${book.author}</h3>
        <h3>$${book.price}</h3>
    </a>
    <br/>
    <br/>

</c:forEach>




</div>
</body>
</html>
