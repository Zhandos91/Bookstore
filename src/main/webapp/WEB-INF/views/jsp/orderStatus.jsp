<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<div class="container">
    <div class="page-header">
        <h1 class="text-danger">Your Orders</h1>
    </div>

    <div class="panel-group">


        <c:forEach items="${orders}" var="order">
            <div class="panel panel-primary">
                <div class="panel-heading">Order</div>
                <div class="panel-body">
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
                </div>
            </div>


            <div class="panel panel-success">
                <div class="panel-heading">Books</div>
                <div class="panel-body">
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
                        <c:forEach var="book" items="${order.books}">
                            <tr class="info">
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.ISBN}</td>
                                <td>$${book.price}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>

            <br/><br/><br/>
        </c:forEach>


    </div>
</div>

<%--<div class="container">--%>
<%--<div class="page-header">--%>
<%--<h1 style="background-color: aquamarine">Your Orders</h1>--%>
<%--</div>--%>


<%--<c:forEach items="${orders}" var="order">--%>
<%--<table class="table">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>Order#</th>--%>
<%--<th>Ordered Date</th>--%>
<%--<th>Status</th>--%>
<%--<th>Method</th>--%>
<%--<th>Tracking#</th>--%>
<%--<th>Expected Delivery</th>--%>
<%--<th>Total Charged</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>

<%--<tr class="danger">--%>
<%--<td>${order.id}</td>--%>
<%--<td>${order.ordered_date}</td>--%>
<%--<td>${order.statuses[0].info}</td>--%>
<%--<td>${order.delivery.type}</td>--%>
<%--<td>${order.tracking_num}</td>--%>
<%--<td>${order.expected_delivery}</td>--%>
<%--<td>$${order.total_price}</td>--%>
<%--</tr>--%>
<%--</tbody>--%>
<%--</table>--%>


<%--<table class="table">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>Title</th>--%>
<%--<th>Author</th>--%>
<%--<th>ISBN</th>--%>
<%--<th>Price</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>
<%--<c:forEach var="book" items="${order.books}" >--%>
<%--<tr class="info">--%>
<%--<td>${book.title}</td>--%>
<%--<td>${book.author}</td>--%>
<%--<td>${book.ISBN}</td>--%>
<%--<td>${book.price}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>

<%--</table>--%>
<%--</c:forEach>--%>


<%--</div>--%>

</body>
</html>
