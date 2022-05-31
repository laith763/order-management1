package com.example.webservicesproject.mappers;


import com.example.webservicesproject.dto.ProductDto;
import com.example.webservicesproject.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public ProductDto convertProductToDto(Product Product){
        ProductDto ProductDto;
        ProductDto = modelMapper.map(Product, ProductDto.class);
        return ProductDto;
    }
    public List<ProductDto> convertListProductToDto(List<Product> Product){
        return Product.stream().map(x -> convertProductToDto(x)).collect(Collectors.toList());
    }
    public Product convertDtoToProduct(ProductDto ProductDto){
        Product Product;
        Product = modelMapper.map(ProductDto, Product.class);
        return Product;
    }
    public List<Product> convertListDtoToProduct(List<ProductDto> dto)
    {
        return dto.stream().map(x -> convertDtoToProduct(x)).collect(Collectors.toList());
    }
}
