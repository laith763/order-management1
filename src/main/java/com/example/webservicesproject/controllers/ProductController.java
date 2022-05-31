package com.example.webservicesproject.controllers;


import com.example.webservicesproject.constants.PathConstants;
import com.example.webservicesproject.dto.ProductDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.Product;
import com.example.webservicesproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Product.RESOURSE_BASE_V0)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProduct() throws ApiRequestException {
        return productService.getAllProduct();
    }

    @GetMapping(PathConstants.ID)
    public ProductDto getProduct(@PathVariable Long id) throws ApiRequestException{
        return productService.getProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) throws ApiRequestException{
        productService.addProduct(product);
    }

    @PatchMapping(PathConstants.ID)
    public void updateProduct(@PathVariable Long id,@RequestBody Product product) throws ApiRequestException{
        productService.updateProduct(id, product);
    }
    @DeleteMapping(PathConstants.ID)
    public void deleteProduct(@PathVariable Long id) throws ApiRequestException{
        productService.deleteProduct(id);
    }
}
