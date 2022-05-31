package com.example.webservicesproject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productId;
    private String name;
    private String reference;
    private int price;
    private boolean stockable;
}
