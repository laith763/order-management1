package com.example.webservicesproject.services.serviceImpl;


import com.example.webservicesproject.dto.StockDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.mappers.StockMapper;
import com.example.webservicesproject.models.Stock;
import com.example.webservicesproject.repositories.StockRepository;
import com.example.webservicesproject.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    
    @Autowired
    StockMapper stockMapper;
    @Autowired
    StockRepository stockRepository;


    @Override
    public List<StockDto> getAllStock(){
        List <Stock> stockList = stockRepository.findAll();
        if(stockList.size() == 0) throw new ApiRequestException("No Stocks in the system");
        return stockMapper.convertListStockToDto(stockList);
    }

    @Override
    public StockDto getStock(Long id){
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Stock that has id %s not found",id)));
        return stockMapper.convertStockToDto(stock);
    }

    @Override
    public void addStock(Stock stock) throws ApiRequestException {
        boolean isStockAlreadyExists = stockRepository.findById(stock.getStockId()).isPresent();
        if(isStockAlreadyExists) throw new ApiRequestException("There is no two Stocks should have the same id");
        stockRepository.save(stock);
    }

    @Override
    public void updateStock(Long id, Stock stock) throws ApiRequestException {
        boolean isStockExists = stockRepository.findById(id).isPresent();
        if(!isStockExists) throw new ApiRequestException("The Stock you are trying to update does not exist");
        stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) throws ApiRequestException {
        boolean isStockExists = stockRepository.findById(id).isPresent();
        if(!isStockExists) throw new ApiRequestException("The Stock you are trying to delete does not exist");
        stockRepository.deleteById(id);
    }
    
    
}
