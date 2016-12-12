<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<spring:url value="/submitOrder" var="submitOrder"/>

<div class="container">

    <sf:form action="${submitOrder}" modelAttribute="creditCard" role="form">


        <div class="row equal">
            <div class="col-xs-6">
                <div class="panel panel-success">
                    <div class="panel-heading"><h3>Shipping To</h3></div>
                    <div class="panel-body">
                        <h4><strong> ${customer.first_name} ${customer.last_name}</strong></h4>
                        <h4>
                            <strong>${customer.addresses[0].city}, ${customer.addresses[0].state} ${customer.addresses[0].zip_code}</strong>
                        </h4>
                        <h4><strong>${customer.addresses[0].country}</strong></h4>
                        <h4><strong>${customer.phone}</strong></h4>
                    </div>

                </div>
            </div>
            <div class="col-xs-6">
                <div class="panel panel-info">
                    <div class="panel-heading"><h3>Credit Card</h3></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="control-label col-xs-4" for="card_type">Card Type:</label>
                            <sf:select path="type" class="control-panel" id="card_type">
                                <sf:option value="NONE">CHOOSE ONE</sf:option>
                                <sf:option value="AMERICAN EXPRESS">AMERICAN EXPRESS</sf:option>
                                <sf:option value="VISA">VISA</sf:option>
                                <sf:option value="MASTERCARD">MASTERCARD</sf:option>
                                <sf:errors path="type" cssClass="error" />
                            </sf:select>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4" for="number">Number: </label>
                            <sf:input path="number" type="text" size="15" id="number"/>
                            <sf:errors path="number" cssClass="error" />
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">Expiration: </label>
                            <sf:input path="month" type="text" size="1" placeholder="mm" id="exp_m"/>
                            <sf:errors path="month" cssClass="error" />

                            <label class="control-label">/</label>
                            <sf:input path="year" type="text" size="1" placeholder="yyyy" id="exp_y"/>
                            <sf:errors path="year" cssClass="error" />
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <c:set var="total" value="${0}"/>

        <h4>
            <div class="form-group">
                <label class="text-primary control-label col-xs-offset-7 col-xs-2">Quantity</label>
                <label class="text-primary control-label col-xs-2">Price</label>
            </div>
            <c:forEach items="${shoppingCart}" var="book">


                <div class="form-group">
                    <label class="control-label col-xs-7 text-warning">
                            ${book.key.title} By ${book.key.author} $${book.key.price}
                    </label>
                    <label class="control-label col-xs-2 text-warning">${book.value}</label>
                    <label class="control-label col-xs-2 text-warning"><c:out
                            value="$${book.value * book.key.price}"/> </label>

                    <c:set var="total" value="${total + book.value * book.key.price}"/>


                </div>
            </c:forEach>
        </h4>
        <br/><br/>
        <br/><br/>
        <h4>
            <div class="form-group">
                <label class="text-danger control-label col-xs-offset-7 col-xs-2">Total Price</label>
                <label class="text-danger control-label col-xs-2">$<fmt:formatNumber type="number"
                                                                                     maxFractionDigits="2"
                                                                                     value="${order.total_price}"/></label>
            </div>
        </h4>

        <br/><br/>
        <br/><br/>
        <h4><label class="text-danger">${order.delivery.type}, ${order.delivery.estimated_time},
            $${order.delivery.cost}</label></h4>

        <div class="form-group">
            <button type="submit" class="col-xs-offset-7 btn btn-primary">ORDER NOW</button>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/listBooks">CANCEL</a>
        </div>


    </sf:form>
</div>


</body>
</html>
