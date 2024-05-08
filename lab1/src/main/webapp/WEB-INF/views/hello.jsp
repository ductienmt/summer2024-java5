<%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/7/2024
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 1 - form</title>
</head>
<body>
    <form action="hello" method="post">
<%--        <input name="name" placeholder="Nhập tên vào đây">--%>
        <input name="username" type="text" placeholder="Nhập username">
    <input name="password" type="password" placeholder="Nhập password">
        <button>Submit</button>
    </form>
</body>
</html>
