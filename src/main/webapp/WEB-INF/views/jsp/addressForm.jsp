
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
<div class="container" >
    <sf:form modelAttribute="address" action="/listBooks" class="form-horizontal" role="form" method="post" >
        <div style="background-color: green" class="page-header"><h2>Address Information</h2></div>

        <div class="form-group" >
            <label class="control-label col-md-2" for="city" >City:</label>
            <div class="col-md-10">
                <sf:input path="city" />
            </div>
        </div>

        <div clas="form-group" >
            <label class="control-label col-md-2" for="state" >State:</label>
            <div class="col-md-10" >
                <sf:input path="state" />
            </div>
        </div>

        <div class="form-group" >
            <label class="control-label col-md-2" for="zip_code" >Zip code:</label>
            <div class="col-md-10" >
                <sf:input path="zip_code" />
            </div>
        </div>

        <div class="form-group" >
            <label class="control-label col-md-2" for="country" >Country:</label>
            <div class="col-md-10" >
                <sf:input path="country" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>

    </sf:form>

</div>

</body>
</html>
