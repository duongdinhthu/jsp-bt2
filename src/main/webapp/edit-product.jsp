<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<h2>Chỉnh sửa sản phẩm</h2>
<form action="products?action=update" method="post">
    <input type="hidden" name="id" value="${product.id}">

    <label>Name:</label>
    <input type="text" name="name" value="${product.name}" required><br>

    <label>Price:</label>
    <input type="number" name="price" step="0.01" value="${product.price}" required><br>

    <label>Description:</label>
    <textarea name="description">${product.description}</textarea><br>

    <input type="submit" value="Cập nhật">
    <a href="products">Hủy</a>
</form>
</body>
</html>
