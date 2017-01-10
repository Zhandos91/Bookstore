<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="page-header"><h2 class="text-success"><spring:message code="ordersubmit.header" /></h2></div>

    <h3 class="text-info"><spring:message code="ordersubmit.thanks" /> </h3>
    <strong><spring:message code="ordersubmit.order_number" />:
        <mark>${order.id}</mark>
    </strong>
    <br/><br/>
    <p><spring:message code="ordersubmit.text" />.</p>
    <br/>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/listBooks"><spring:message code="ordersubmit.button"/></a>
</div>

</body>
</html>
