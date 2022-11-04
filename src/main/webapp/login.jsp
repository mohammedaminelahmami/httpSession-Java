<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/4/2022
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/dashboard" method="POST">
        <label for="username"> Username :
            <input type="text" name="username" id="username">
        </label>

        <label for="password"> Password :
            <input type="text" name="password" id="password">
        </label>

        <button type="submit">Login</button>
    </form>
</body>
</html>
