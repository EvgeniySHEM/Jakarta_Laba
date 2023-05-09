<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authorization page</title>
</head>
<body>
<form action="Authorization-servlet" method="post" align="center">
    <p>
    <h1><%= "Authorization" %>
    </h1></p>
    <p><label>Username</label></p>
    <p><input type="text" name="username" placeholder="username" required></p>
    <p><label>Password</label></p>
    <p><input type="password" name="password" placeholder="password" required></p>
    <p><input type="submit" value="Sing in"></p>
</form>
<form action="ViewListServlet" method="get" align="center">
    <p><input type="text" name="filter" placeholder="filter"></p>
    <p><input type="submit" value="Filter"></p>
</form>

<%--<table align="center" cellpadding="5" border="1" cellspacing="0" text-align="center">--%>
<%--    <tr>--%>
<%--        <th>clientId</th>--%>
<%--        <th>clientName</th>--%>
<%--        <th>type</th>--%>
<%--        <th>added</th>--%>
<%--        <th>ip</th>--%>
<%--        <th>mac</th>--%>
<%--        <th>model</th>--%>
<%--        <th>address</th>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--    </tr>--%>
<%--</table>--%>
</body>
</html>