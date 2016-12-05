<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
</head>
<body>

<table border="1" width="100%" height="100%" cellpadding="2" cellspacing="2">
    <tr>
        <td height="10%" colspan="2">
            <tiles:insertAttribute name="header" ignore="true" />
        </td>
    </tr>
    <tr>
        <td width="10%" nowrap="nowrap">
            <tiles:insertAttribute name="menu" />
        </td>
        <td width="90%">
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>

</body>
</html>
