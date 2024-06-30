package com.shopee.product_service.controller;

import com.shopee.product_service.entity.Product;
import com.shopee.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Product controller called");
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/createproduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        String resp = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);

    }

}
