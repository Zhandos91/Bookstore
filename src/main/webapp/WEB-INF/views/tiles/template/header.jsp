<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
</head>
<body>

<h2>
    <a href="${pageContext.request.contextPath}/listBooks">
        <span class="glyphicon glyphicon-book"><spring:message code="app_name" /></span>
    </a>

    <a href="${pageContext.request.contextPath}/logout" class="btn btn-info btn-md" style="float:right">
        <span class="glyphicon glyphicon-log-out"></span><spring:message code="logout" />
    </a>
</h2>

<div style="float:right">
    <a href="?lang=en" class="btn btn-sm btn-primary"><spring:message code="language.english" /></a>
    <a href="?lang=ru" class="btn btn-sm btn-primary"><spring:message code="language.russian" /> </a>
</div>

</body>
</html>
