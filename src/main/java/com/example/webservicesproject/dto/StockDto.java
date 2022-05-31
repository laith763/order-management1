package com.example.webservicesproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private Long stockId;
    private int quantity;
    private Date updateAt;
}
