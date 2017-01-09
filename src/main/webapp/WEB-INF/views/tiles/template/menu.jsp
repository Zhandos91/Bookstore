<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="padding: 5px;background-color: yellowgreen; margin-top: 50px;position: fixed;width: 10%;top:83px" align="center">
    <h4><a class="text-warning" href="${pageContext.request.contextPath}/listBooks"><spring:message code="menu.link.home" /></a></h4>
    <h4><a class="text-warning" href="${pageContext.request.contextPath}/addAddress"><spring:message code="menu.link.add_address" /></a></h4>
    <h4><a class="text-warning" href="${pageContext.request.contextPath}/orderStatus"><spring:message code="menu.link.order_status" /></a></h4>
    <h4><a class="text-warning" href="${pageContext.request.contextPath}/showShoppingCart"><spring:message code="menu.link.shopping_cart" /></a></h4>
</div>

</body>
</html>
