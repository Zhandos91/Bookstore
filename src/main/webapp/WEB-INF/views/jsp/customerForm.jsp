
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
        <h1 class="text-danger">Customer Information</h1>
    </div>


    <sf:form id="registrationForm" class="form-horizontal" role="form" modelAttribute="customer" method="post">


        <div class="form-group">
            <label class="control-label col-md-2" for="first_name">First Name: </label>
            <div class="col-md-10">
                <sf:input path="first_name"/>
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="last_name">Last Name:</label>
            <div class="col-md-10">
                <sf:input path="last_name"/>
            </div>

        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="phone">Phone Number:</label>
            <div class="col-md-10">
                <sf:input path="phone"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="email">Email:</label>
            <div class="col-md-10">
                <sf:input type="email" path="email"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="password">Password:</label>
            <div class="col-md-10">
                <sf:password path="password"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-md-2" for="confirm_password">Confirm Password:</label>
            <div class="col-md-10">
                <sf:password path="confirm_password"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-primary">Next</button>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/">CANCEL</a>
            </div>
        </div>

        <div style="color:red">${signupError}</div>
    </sf:form>
</div>
</body>
</html>
