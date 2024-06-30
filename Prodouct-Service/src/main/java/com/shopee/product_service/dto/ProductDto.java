package com.shopee.product_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String product_name;
    private String product_desc;
    private Integer product_price;
}
