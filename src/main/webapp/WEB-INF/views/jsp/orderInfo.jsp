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


<div class="container">

    <sf:form class="form-inline" role="form">


        <h2>Shipping To</h2>

        <h3> ${customer.first_name} ${customer.last_name}</h3>
        <h3>${customer.addresses[0].city}, ${customer.addresses[0].state} ${customer.addresses[0].zip_code}</h3>
        <h3>${customer.addresses[0].country}</h3>
        <h3>${customer.phone}</h3>

        <h2>Credit Card</h2>


        <div class="form-group">
            <label class="control-label" for="card_type">Card Type:</label>
            <select class="control-panel" id="card_type">
                <option value="">CHOOSE ONE</option>
                <option value="ADMIN">AMERICAN EXPRESS</option>
                <option value="STUDENT">VISA</option>
                <option value="TEACHER">MASTERCARD</option>
            </select>
        </div>
        <div class="form-group">
            <label class="control-label" for="number">Number: </label>
            <input type="text" id="number"/>
        </div>

        <div class="form-group">
            <label class="control-label">Expiration: </label>
            <input type="text" id="exp_m"/>

            <label class="control-label">/</label>
            <input type="text" id="exp_y"/>
        </div>


    </sf:form>
</div>


</body>
</html>
