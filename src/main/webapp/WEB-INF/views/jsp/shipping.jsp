<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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

<sf:form modelAttribute="shipping">


    <sf:radiobutton path="type" value="Next Day Air"></sf:radiobutton>
    <sf:radiobutton path="type" value="Second Day Air"></sf:radiobutton>
    <sf:radiobutton path="type" value="Priority"></sf:radiobutton>
    <sf:radiobutton path="type" value="Standard Ground Delivery"></sf:radiobutton>

</sf:form>
</body>
</html>
