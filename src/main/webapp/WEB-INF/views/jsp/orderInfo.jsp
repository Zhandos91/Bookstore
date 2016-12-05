<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<spring:url value="/submitOrder" var="submitOrder" />

<div class="container">

    <sf:form action="${submitOrder}" modelAttribute="order" role="form">



        <div class="row">
            <div class="col-xs-6">
                <div class="panel panel-success">
                    <div class="panel-heading"><h3>Shipping To</h3></div>
                    <div class="panel-body">
                        <h4> ${customer.first_name} ${customer.last_name}</h4>
                        <h4>${customer.addresses[0].city}, ${customer.addresses[0].state} ${customer.addresses[0].zip_code}</h4>
                        <h4>${customer.addresses[0].country}, ${customer.phone}</h4>

                    </div>

                </div>
            </div>
            <div class="col-xs-6">
                <div class="panel panel-info">
                    <div class="panel-heading"><h3>Credit Card</h3></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="control-label col-xs-4" for="card_type">Card Type:</label>
                            <select class="control-panel" id="card_type">
                                <option value="">CHOOSE ONE</option>
                                <option value="ADMIN">AMERICAN EXPRESS</option>
                                <option value="STUDENT">VISA</option>
                                <option value="TEACHER">MASTERCARD</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4" for="number">Number: </label>
                            <input type="text" size="15" id="number"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">Expiration: </label>
                            <input type="text" size="1" placeholder="mm" id="exp_m"/>

                            <label class="control-label">/</label>
                            <input type="text" size="1" placeholder="yyyy" id="exp_y"/>
                        </div>

                    </div>
                </div>
            </div>
        </div>





        <%--<h2>Shipping To</h2>--%>

        <%--<h3> ${customer.first_name} ${customer.last_name}</h3>--%>
        <%--<h3>${customer.addresses[0].city}, ${customer.addresses[0].state} ${customer.addresses[0].zip_code}</h3>--%>
        <%--<h3>${customer.addresses[0].country}</h3>--%>
        <%--<h3>${customer.phone}</h3>--%>

        <%--<h2>Credit Card</h2>--%>


        <%--<div class="form-group">--%>
            <%--<label class="control-label" for="card_type">Card Type:</label>--%>
            <%--<select class="control-panel" id="card_type">--%>
                <%--<option value="">CHOOSE ONE</option>--%>
                <%--<option value="ADMIN">AMERICAN EXPRESS</option>--%>
                <%--<option value="STUDENT">VISA</option>--%>
                <%--<option value="TEACHER">MASTERCARD</option>--%>
            <%--</select>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label" for="number">Number: </label>--%>
            <%--<input type="text" id="number"/>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<label class="control-label">Expiration: </label>--%>
            <%--<input type="text" id="exp_m"/>--%>

            <%--<label class="control-label">/</label>--%>
            <%--<input type="text" id="exp_y"/>--%>
        <%--</div>--%>



        <c:set var="total" value="${0}"/>

        <h2>
            <div class="form-group">
                <label class="text-primary control-label col-xs-offset-7 col-xs-2">Quantity</label>
                <label class="text-primary control-label col-xs-2">Price</label>
            </div>
            <c:forEach items="${shoppingCart}" var="book">



                <div class="form-group" style="background-color: yellow">
                    <label class="control-label col-xs-7">
                        ${book.key.title} By ${book.key.author} $${book.key.price}
                    </label>
                    <label class="control-label col-xs-2">${book.value}</label>
                    <label class="control-label col-xs-2"><c:out value="$${book.value * book.key.price}"/> </label>

                    <c:set var="total" value="${total + book.value * book.key.price}"/>


                </div>
            </c:forEach>

            <br/><br/>
                <label class="control-label">${order.delivery.type}, ${order.delivery.estimated_time}, $${order.delivery.cost} </label>



            <div class="form-group">
                <label class="text-danger control-label col-xs-offset-7 col-xs-2">Total Price</label>
                <label class="text-danger control-label col-xs-2">$<fmt:formatNumber type="number"
                                                                                     maxFractionDigits="2"
                                                                                     value="${order.total_price}" /></label>
            </div>
        </h2>

        <br/><br/>
        <br/><br/>

        <div class="form-group">
            <h2>
                <button style="float: right;" type="submit" class="col-xs-offset-2 btn btn-primary">ORDER NOW</button>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/listBooks">CANCEL</a>
            </h2>
        </div>



    </sf:form>
</div>


</body>
</html>
