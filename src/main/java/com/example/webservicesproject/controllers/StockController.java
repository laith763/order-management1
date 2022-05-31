package com.example.webservicesproject.controllers;


import com.example.webservicesproject.constants.PathConstants;
import com.example.webservicesproject.dto.StockDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.Stock;
import com.example.webservicesproject.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Stock.RESOURSE_BASE_V0)
public class StockController {


    @Autowired
    private StockService stockService;


    @GetMapping
    public List<StockDto> getAllStock() throws ApiRequestException {
        return stockService.getAllStock();
    }

    @GetMapping(PathConstants.ID)
    public StockDto getStock(@PathVariable Long id) throws ApiRequestException{
        return  stockService.getStock(id);
    }

    @PostMapping
    public void addStock(@RequestBody Stock stock) throws ApiRequestException{
        stockService.addStock(stock);
    }

    @PatchMapping(PathConstants.ID)
    public void updateStock(@PathVariable Long id,@RequestBody Stock stock) throws ApiRequestException{
        stockService.updateStock(id, stock);
    }
    @DeleteMapping(PathConstants.ID)
    public void deleteStock(@PathVariable Long id) throws ApiRequestException{
        stockService.deleteStock(id);
    }
}
