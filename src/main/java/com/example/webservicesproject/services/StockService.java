package com.example.webservicesproject.services;

import com.example.webservicesproject.dto.StockDto;
import com.example.webservicesproject.models.Stock;

import java.util.List;

public interface StockService {

    List<StockDto> getAllStock();

    StockDto getStock(Long id) ;

    void addStock(Stock Stock) ;

    void updateStock(Long id, Stock Stock) ;

    void deleteStock(Long id) ;
}
