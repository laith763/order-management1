package com.example.webservicesproject.mappers;


import com.example.webservicesproject.dto.StockDto;
import com.example.webservicesproject.models.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    private ModelMapper modelMapper;

    public StockDto convertStockToDto(Stock Stock){
        StockDto StockDto;
        StockDto = modelMapper.map(Stock, StockDto.class);
        return StockDto;
    }
    public List<StockDto> convertListStockToDto(List<Stock> Stock){
        return Stock.stream().map(x -> convertStockToDto(x)).collect(Collectors.toList());
    }
    public Stock convertDtoToStock(StockDto StockDto){
        Stock Stock;
        Stock = modelMapper.map(StockDto, Stock.class);
        return Stock;
    }
    public List<Stock> convertListDtoToStock(List<StockDto> dto)
    {
        return dto.stream().map(x -> convertDtoToStock(x)).collect(Collectors.toList());
    }

}
