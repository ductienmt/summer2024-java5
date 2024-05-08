<%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/7/2024
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Lab 1 - result</title>
</head>
<body>
<%--<h1>Hello: ${name_hello}</h1>--%>
<h1>Cách 1 (xử dụng HttpServletRequest req, HttpServletResponse res, HttpSession session)</h1>
<h3>Username: ${username}</h3>
<h3>Password: ${password}</h3>
<h1>Cách 2 (xử dụng @ModelAttribute)</h1>
<h3>Username: ${user.username}</h3>
<h3>Password: ${user.password}</h3>
</body>
</html>
