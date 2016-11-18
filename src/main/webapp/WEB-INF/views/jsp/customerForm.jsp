<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 11/17/2016
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
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

    <sf:form id="registrationForm" class="form-horizontal" role="form" commandName="customer" method="post">

        <div style="background-color: green" class="page-header"><h2>Customer Information</h2></div>


        <div class="form-group">
            <label class="control-label col-md-2" for="first_name">First Name: </label>
            <div class="col-md-10">
                <sf:input path="first_name"/>
            </div>
        </div>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-md-2" for="last_name">Last Name:</label>--%>
            <%--<div class="col-md-10">--%>
                <%--<input type="text" class="form-control" id="last_name" name="last_name" placeholder="Enter Last Name">--%>
            <%--</div>--%>
        <%--</div>--%>


        <%--<div class="form-group">--%>
            <%--<label class="control-label col-md-2" for="email">Email:</label>--%>
            <%--<div class="col-md-10">--%>
                <%--<input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<label class="control-label col-md-2" for="password">Password:</label>--%>
            <%--<div class="col-md-10">--%>
                <%--<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">--%>
            <%--</div>--%>

        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<label class="control-label col-md-2" for="confirm_password">Confirm Password:</label>--%>
            <%--<div class="col-md-10">--%>
                <%--<input type="password" class="form-control" id="confirm_password" name="confirm_password"--%>
                       <%--placeholder="Retype Password">--%>
            <%--</div>--%>
        <%--</div>--%>


        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>

        <div style="color:red">${signupError}</div>
    </sf:form>
</div>
</body>
</html>
