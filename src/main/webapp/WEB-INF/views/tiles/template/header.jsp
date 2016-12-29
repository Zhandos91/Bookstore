<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<h2>
    <a href="${pageContext.request.contextPath}/listBooks">
        <span class="glyphicon glyphicon-book">Bookstore</span>
    </a>

    <a href="${pageContext.request.contextPath}/logout" class="btn btn-info btn-lg" style="float:right">
        <div class="row">
            <a href="?lang=en" class="btn btn-sm btn-success">English</a> <a href="?lang=ru" class="btn btn-sm btn-success">French</a>
        </div>
        <span class="glyphicon glyphicon-log-out"></span> Log out
    </a>
</h2>

</body>
</html>
