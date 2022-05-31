package com.example.webservicesproject.services;

import com.example.webservicesproject.dto.ProductDto;
import com.example.webservicesproject.models.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProduct();

    ProductDto getProduct(Long id) ;

    void addProduct(Product Product) ;

    void updateProduct(Long id, Product Product) ;

    void deleteProduct(Long id) ;
}
