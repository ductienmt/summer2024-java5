<%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/8/2024
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Thêm các tài nguyên Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form action="/ctrl/ok" method="post">
        <button type="submit" class="btn btn-primary">OK 1</button>
        <button type="submit" class="btn btn-primary" formmethod="get">OK 2</button>
        <button type="submit" class="btn btn-primary" formaction="/ctrl/ok?x">OK 3</button>
    </form>
    <h5>Kết quả: ${mess}</h5>
</div>
</body>
</html>

