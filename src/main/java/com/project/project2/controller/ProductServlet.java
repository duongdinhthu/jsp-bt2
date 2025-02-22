package com.project.project2.controller;




import com.project.project2.model.Product;
import com.project.project2.model.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                request.getRequestDispatcher("add-product.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", productDAO.getProductById(id));
                request.getRequestDispatcher("edit-product.jsp").forward(request, response);
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                productDAO.deleteProduct(deleteId);
                response.sendRedirect("products");
                break;
            default:
                List<Product> products = productDAO.getAllProducts();
                request.setAttribute("products", products);
                request.getRequestDispatcher("list-products.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            productDAO.addProduct(new Product(0, name, price, description));
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            productDAO.updateProduct(new Product(id, name, price, description));
        }

        response.sendRedirect("products");
    }
}

