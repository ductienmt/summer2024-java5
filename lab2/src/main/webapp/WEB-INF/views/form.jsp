<%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/9/2024
  Time: 1:13 AM
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
    <form action="/param/save/2022" method="post">
        <div class="form-group">
            <label for="y">Giá trị y:</label>
            <input type="text" class="form-control" id="y" name="y" value="2031">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
    <hr>
    <ul class="list-group">
        <li class="list-group-item">Giá trị của x: ${x}</li>
        <li class="list-group-item">Giá trị của y: ${y}</li>
    </ul>
</div>
</body>
</html>

