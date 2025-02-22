<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm</h2>
<form action="products?action=insert" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br>

    <label>Price:</label>
    <input type="number" name="price" step="0.01" required><br>

    <label>Description:</label>
    <textarea name="description"></textarea><br>

    <input type="submit" value="Lưu">
    <a href="products">Hủy</a>
</form>
</body>
</html>
