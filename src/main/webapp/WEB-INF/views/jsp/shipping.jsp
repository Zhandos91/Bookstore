<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Shipping Methods</h2>

<sf:form modelAttribute="delivery" method="post">

    <c:forEach items="${delivery_methods}" var="mydelivery">
        <div class="form-group">
            <label class="control-label col-xs-6"><sf:radiobutton path="type" value="${mydelivery.type}" />${mydelivery.type} </label>
            <label class="control-label col-xs-3">${mydelivery.estimated_time} </label>
            <label class="control-label col-xs-3">$${mydelivery.cost} </label>
        </div>
    </c:forEach>


    <button style="float: right;" type="submit" class="col-xs-offset-2 btn btn-primary">NEXT</button>
</sf:form>
</body>
</html>
