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
    <div class="page-header"><h2 class="text-success">Order Complete</h2></div>

    <h3 class="text-info">Thank you for the order!</h3>
    <strong>Your order number is:
        <mark>${order.id}</mark>
        ${o}
    </strong>
    <br/><br/>
    <p>Once your order has been shipped we will notify you via the e-mail address that is listed in your your account
        information.You can
        review the status of your order at any time by clicking the Order Stratus button in the navigation menu.</p>
    <br/>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/listBooks">CONTINUE</a>
</div>

</body>
</html>
