
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Online Bookstore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="page-header"><h2>Welcome To Online Bookstore!</h2></div>

    <h4>
        News customers, please, sign up <a href="${pageContext.request.contextPath}/signup">HERE</a>
        <br/><br/>
        Returning customers, please, log in <a href="${pageContext.request.contextPath}/login">HERE</a>
    </h4>
</div>

</body>
</html>
