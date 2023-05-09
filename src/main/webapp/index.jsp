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
    <select name="select">
        <option value="t1">Пункт 1</option>
        <option value="t2">Пункт 2</option>
    </select>
</form>
</body>
</html>