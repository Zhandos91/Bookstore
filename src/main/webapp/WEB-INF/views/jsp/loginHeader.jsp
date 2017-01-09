<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <style>
        .RbtnMargin {
            margin-left: 5px;
        }
    </style>
</head>
<body>
<a href="#">
    <h2><span class="glyphicon glyphicon-book"><spring:message code="app_name" /></span>
        <a href="?lang=ru" class="btn pull-right btn-sm btn-primary RbtnMargin"><spring:message code="language.russian" /></a>
        <a href="?lang=en" class="btn pull-right btn-sm btn-primary"><spring:message code="language.english" /></a>
    </h2>
</a>
</body>
</html>
