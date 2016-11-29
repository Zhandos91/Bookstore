<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="page-header">
        <h1 style="background-color: aquamarine">Your Orders</h1>
    </div>



    <table class="table">
        <thead>
        <tr>
            <th>Order#</th>
            <th>Ordered Date</th>
            <th>Status</th>
            <th>Method</th>
            <th>Tracking#</th>
            <th>Expected Delivery</th>
            <th>Total Charged</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
        <tr class="danger">
            <td>${order.id}</td>
            <td>${order.ordered_date}</td>
            <td>${order.statuses[0].info}</td>
            <td>${order.delivery.type}</td>
            <td>${order.tracking_num}</td>
            <td>${order.expected_delivery}</td>
            <td>$${order.total_price}</td>
        </tr>
        </tbody>
    </table>


    <table class="table">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${order.books}" >
        <tr class="info">
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.ISBN}</td>
            <td>${book.price}</td>
        </tr>
        </c:forEach>
        </tbody>
        </c:forEach>
    </table>




</div>

</body>
</html>
