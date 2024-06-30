package com.shopee.product_service.service;

import com.shopee.product_service.entity.Product;
import com.shopee.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long id) {
        Product product =  productRepository.findById(id).get();

        log.info("Get Product By id = {} ---- Product details {} " , id, product);
        return product;

    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public String updateProduct(Product product) {
        return null;
    }

    @Override
    public String createProduct(Product product) {
        Product p =  productRepository.save(product);
        if( p != null && p.getProduct_id() != null){
            return "Product saved created...";
        }else{
            return "Product not created...";
        }
    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }
}
