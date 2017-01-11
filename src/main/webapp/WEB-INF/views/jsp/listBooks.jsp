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

<c:forEach items="${bookList}" var="book">

    <a href="${pageContext.request.contextPath}/${book.id}">
        <h3>${book.title}</h3>
        <h3>${book.author}</h3>
        <h3>$${book.price}</h3>
    </a>
    <br/>
    <br/>

</c:forEach>

    <img src="http://www.w3schools.com/w3images/fjords.jpg" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">
    <spring:url value="/resources/images" var="images" />


    <img src="${images}/nature.jpg" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">

</div>
</body>
</html>
