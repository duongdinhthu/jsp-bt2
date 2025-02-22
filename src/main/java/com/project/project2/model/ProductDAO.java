package com.project.project2.model;


import java.util.ArrayList;
import java.util.List;



public class ProductDAO {
    private static List<Product> products = new ArrayList<>();
    private static int idCounter = 1;

    // Lấy danh sách sản phẩm
    public List<Product> getAllProducts() {
        return products;
    }

    // Thêm sản phẩm mới
    public void addProduct(Product product) {
        product.setId(idCounter++);
        products.add(product);
    }

    // Tìm sản phẩm theo ID
    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    // Cập nhật sản phẩm
    public void updateProduct(Product product) {
        Product existing = getProductById(product.getId());
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}

