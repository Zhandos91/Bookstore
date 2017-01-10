
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<div class="container" >

    <div class="page-header">
        <h1 class="text-danger"><spring:message code="address.label.header" /></h1>
    </div>


    <sf:form modelAttribute="address" class="form-horizontal" role="form" method="post" >

        <div class="form-group" >
            <label style="text-align: right" class="control-label col-xs-2" for="city" ><spring:message code="address.label.city" />:</label>
            <div class="col-xs-10">
                <sf:input path="city" />
                <sf:errors path="city" cssClass="error" />
            </div>
        </div>

        <div class="form-group" >
            <label style="text-align: right" class="control-label col-xs-2" for="state" ><spring:message code="address.label.state" />:</label>
            <div class="col-xs-10" >
                <sf:input path="state" />
                <sf:errors path="state" cssClass="error" />
            </div>
        </div>

        <div class="form-group" >
            <label style="text-align: right" class="control-label col-xs-2" for="zip_code" ><spring:message code="address.label.zip_code" />:</label>
            <div class="col-xs-10" >
                <sf:input path="zip_code" />
                <sf:errors path="zip_code" cssClass="error" />
            </div>
        </div>

        <div class="form-group" >
            <label style="text-align: right" class="control-label col-xs-2" for="country" ><spring:message code="address.label.country" />:</label>
            <div class="col-xs-10" >
                <sf:input path="country" />
                <sf:errors path="country" cssClass="error" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary"><spring:message code="address.button.submit" /></button>
                <%--<c:if test="${not empty customer.addresses}" >--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/listBooks"><spring:message code="address.button.cancel" /> </a>
                <%--</c:if>--%>
            </div>
        </div>

    </sf:form>

</div>

</body>
</html>
