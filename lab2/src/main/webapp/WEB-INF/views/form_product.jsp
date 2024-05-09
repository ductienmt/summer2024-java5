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
    <h2>Form sản phẩm</h2>
    <form action="/product/save" method="post">
        <div class="form-group">
            <label for="name">Tên sản phẩm:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="price">Giá tiền:</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
    <hr>
    <h2>Thông tin sản phẩm</h2>
    <ul class="list-group">
        <li class="list-group-item">Tên sản phẩm: ${product.name}</li>
        <li class="list-group-item">Giá tiền: ${product.price}</li>
    </ul>
</div>
</body>
</html>
