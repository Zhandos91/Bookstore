<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <h1 class="text-danger"><spring:message code="status.header" /></h1>
    </div>

    <div class="panel-group">


        <c:forEach items="${orders}" var="order" varStatus="loop">
            <div class="panel panel-primary">
                <div class="panel-heading"><spring:message code="status.order.header" />#${loop.index + 1}</div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th><spring:message code="status.order.row.order"/>#</th>
                            <th><spring:message code="status.order.row.date"/></th>
                            <th><spring:message code="status.order.row.status"/></th>
                            <th><spring:message code="status.order.row.method"/></th>
                            <th><spring:message code="status.order.row.tracking"/>#</th>
                            <th><spring:message code="status.order.row.delivery"/></th>
                            <th><spring:message code="status.order.row.charged"/></th>
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
                <div class="panel-heading"><spring:message code="status.book.header"/></div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th><spring:message code="status.book.row.quantity"/></th>
                            <th><spring:message code="status.book.row.title"/></th>
                            <th><spring:message code="status.book.row.author"/></th>
                            <th><spring:message code="status.book.row.isbn"/></th>
                            <th><spring:message code="status.book.row.price"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="orderBook" items="${order.orderBooks}">
                            <tr class="info">
                                <td>${orderBook.quantity}</td>
                                <td>${orderBook.book.title} </td>
                                <td>${orderBook.book.author}</td>
                                <td>${orderBook.book.ISBN}</td>
                                <td>$${orderBook.book.price}</td>
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



</body>
</html>
