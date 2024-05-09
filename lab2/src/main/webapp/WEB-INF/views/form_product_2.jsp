<%@ page import="com.lab2.model.product" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/9/2024
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Form</title>
    <!-- Đường dẫn tới file CSS của Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<%--    <base href="${pageContext.servletContext.contextPath}">--%>
</head>
<body>

<div class="container">
    <h1 class="mt-5">Product Form</h1>

    <!-- Form nhập liệu -->
    <form action="/product2/save" method="post" class="mt-3">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.name}">
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" name="price" value="${product.price}">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

    <h2 class="mt-5">Product List</h2>

    <!-- Bảng danh sách sản phẩm -->
    <table class="table mt-3">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${product.name}</td>
            <td>${product.price} $</td>
        </tr>
        <!-- Sử dụng for để lặp qua danh sách sản phẩm -->
        <%
            List<product> items = (List<product>) request.getAttribute("items");
            if (items != null) {
                for (product item : items) {
                    System.out.println(item.getName() + " " + item.getPrice());
        %>
        <tr>
            <td><%= item.getName() %></td>
            <td><%= item.getPrice() %> $</td>
        </tr>
        <%
                }
            }
        %>

        </tbody>
    </table>
</div>

<!-- Đường dẫn tới file JavaScript của Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>


