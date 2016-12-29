<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<html>--%>
<%--<body>--%>
<%--<h1>Spring MVC internationalization example</h1>--%>

<%--Language : <a href="?lang=en">English</a>|<a href="?lang=ru">Russian</a>--%>

<%--<h2>--%>
    <%--welcome.springmvc : <spring:message code="welcome" text="default text" />--%>
<%--</h2>--%>

<%--<h2>--%>
    <%--welcome.springmvc : <spring:message code="NotNull.addressForm.city" text="default text" />--%>
<%--</h2>--%>

<%--Current Locale : ${pageContext.response.locale}--%>


<%--</body>--%>
<%--</html>--%>




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
    <div class="page-header"><h2>Welcome To Online Bookstore!</h2></div>

    <h4>
        News customers, please, sign up <a href="${pageContext.request.contextPath}/signup">HERE</a>
        <br/><br/>
        Returning customers, please, log in <a href="${pageContext.request.contextPath}/login">HERE</a>
    </h4>
</div>

<h2>
welcome.springmvc : <spring:message code="welcome" text="default text" />
</h2>

<h2>
welcome.springmvc : <spring:message code="NotNull.addressForm.city" text="default text" />
</h2>

Current Locale : ${pageContext.response.locale}

</body>
</html>

