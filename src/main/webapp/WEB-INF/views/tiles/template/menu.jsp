<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="background-color: green">

    <div>
        <h4 align="center">Account Info</h4>
    </div>

    <div style="padding: 5px;background-color: aliceblue">
        <ul>
            <li><a href="${pageContext.request.contextPath}/listBooks">home</a></li>
            <li><a href="${pageContext.request.contextPath}/addAddress">add address</a></li>
            <li><a href="${pageContext.request.contextPath}/orderStatus">order status</a></li>
            <li><a href="${pageContext.request.contextPath}/showShoppingCart">shopping cart</a></li>
        </ul>
    </div>

</div>
</body>
</html>
