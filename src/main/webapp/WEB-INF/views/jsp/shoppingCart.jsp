
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

    <div class="page-header"><label><h3>Your Cart</h3></label></div>

    <c:forEach items="${shoppingCart}" var="book" >
        ${book.author}
        ${book.publisher}


    </c:forEach>
    <%--<form class="form-horizontal">--%>




    <%--<div class="form-group" >--%>
        <%--<label class="control-label col-md-2" for="email">Email:</label>--%>
        <%--<div class="col-md-10">--%>
            <%--<input type="email" class="form-control" id="email" placeholder="Enter email">--%>
        <%--</div>--%>

    <%--</div>--%>
    <%--</form>--%>

</div>
</body>
</html>
