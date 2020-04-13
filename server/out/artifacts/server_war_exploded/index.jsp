<%--
  Created by IntelliJ IDEA.
  User: ggolfz
  Date: 11/4/2020 AD
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Register
  <form method="POST" action ="RegisterServlet">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
  </form>
  Login
  <form method="POST" action = "LoginServlet">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
  </form>
  </body>
</html>
