<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh sách sản phẩm</h2>
<a href="products?action=new">Thêm sản phẩm</a>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Price</th><th>Description</th><th>Actions</th></tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <a href="products?action=edit&id=${product.id}">Edit</a>
                <a href="products?action=delete&id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
