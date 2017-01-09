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
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="page-header">
        <h1 class="text-danger"><spring:message code="signup.header" /></h1>
    </div>


    <sf:form id="registrationForm" class="form-horizontal" role="form" modelAttribute="customer" method="post">


        <div class="form-group">
            <label class="control-label col-md-2" for="first_name"><spring:message code="signup.first_name" />:</label>
            <div class="col-md-10">
                <sf:input path="first_name"/>
                <sf:errors path="first_name"  cssClass="error"  />
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="last_name"><spring:message code="signup.last_name" />:</label>
            <div class="col-md-10">
                <sf:input path="last_name"/>
                <sf:errors path="last_name" class="control-label " cssClass="error"  />
            </div>

        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="phone"><spring:message code="signup.phone_number" />:</label>
            <div class="col-md-10">
                <sf:input type="number" path="phone"/>
                <sf:errors path="phone" class="control-label"  cssClass="error" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="email"><spring:message code="signup.email" />:</label>
            <div class="col-md-10">
                <sf:input type="email" path="email"/>
                <sf:errors path="email" class="control-label"  cssClass="error" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="password"><spring:message code="signup.password" />:</label>
            <div class="col-md-10">
                <sf:password path="password"/>
                <sf:errors path="password" class="control-label"   cssClass="error" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="confirm_password"><spring:message code="signup.confrim_password" />:</label>
            <div class="col-md-10">
                <sf:password path="confirm_password"/>
                <sf:errors path="confirm_password" class="control-label"  cssClass="error" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-primary"><spring:message code="signup.button.next" /></button>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/"><spring:message code="signup.button.cancel" /></a>
            </div>
        </div>

    </sf:form>
</div>
</body>
</html>
