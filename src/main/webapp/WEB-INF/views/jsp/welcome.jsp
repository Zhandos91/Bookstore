<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Bookstore</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

</head>
<body>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<div class="container">
    <div class="page-header"><h2><spring:message code="welcome.header" /></h2></div>

    <img src="http://178.33.143.235/wp-content/uploads/2014/12/MG_4451-b2.jpg" class="img-thumbnail" alt="Bookstore" width="404" height="336">

    <h4>
        <spring:message code="welcome.signup" /> <a href="${pageContext.request.contextPath}/signup"><spring:message code="welcome.link" /></a>
        <br/><br/>
        <spring:message code="welcome.login" /> <a href="${pageContext.request.contextPath}/login"><spring:message code="welcome.link" /></a>
    </h4>
</div>

</body>
</html>

