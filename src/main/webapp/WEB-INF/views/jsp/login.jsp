<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">

    <sf:form class="form-inline" role="form" modelAttribute="customer" method="post">

    <div class="page-header"><h2><spring:message code="login.header" /></h2></div>

    <div class="form-group">
        <label class="control-label" for="email"><spring:message code="login.login" />:</label>
        <sf:input path="email" type="email" class="form-control" placeholder="Enter login"/>
    </div>

    <div class="form-group">
        <label class="control-label" for="password"><spring:message code="login.password" />:</label>
        <sf:input path="password" class="form-control" type="password" placeholder="Enter password"/>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="login.button" /></button>

        <br/><br/>
        <sf:errors path="password" cssClass="error"/>
    </sf:form>


</body>

</html>
