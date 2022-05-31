package com.example.webservicesproject.services.serviceImpl;

import com.example.webservicesproject.dto.ProductDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.mappers.ProductMapper;
import com.example.webservicesproject.models.Product;
import com.example.webservicesproject.repositories.ProductRepository;
import com.example.webservicesproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProduct(){
        List <Product> productList = productRepository.findAll();
        if(productList.size() == 0) throw new ApiRequestException("No Products in the system");
        return productMapper.convertListProductToDto(productList);
    }

    @Override
    public ProductDto getProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Product that has id %s not found",id)));
        return productMapper.convertProductToDto(product);
    }

    @Override
    public void addProduct(Product product) throws ApiRequestException {
        boolean isProductAlreadyExists = productRepository.findById(product.getProductId()).isPresent();
        if(isProductAlreadyExists) throw new ApiRequestException("There is no two Products should have the same id");
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) throws ApiRequestException {
        boolean isProductExists = productRepository.findById(id).isPresent();
        if(!isProductExists) throw new ApiRequestException("The Product you are trying to update does not exist");
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws ApiRequestException {
        boolean isProductExists = productRepository.findById(id).isPresent();
        if(!isProductExists) throw new ApiRequestException("The Product you are trying to delete does not exist");
        productRepository.deleteById(id);
    }
}
