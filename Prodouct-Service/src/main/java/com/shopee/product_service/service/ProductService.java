package com.shopee.product_service.service;

import com.shopee.product_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product getProductById(long id);
    public List<Product> getAllProduct();
    public String updateProduct(Product product);
    public String createProduct(Product product);
    public String deleteProductById(Long id);
}
