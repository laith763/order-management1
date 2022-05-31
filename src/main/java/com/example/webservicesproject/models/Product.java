package com.example.webservicesproject.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue
    private Long productId;
    private String slug;
    private String name;
    private String reference;
    private int price;
    private int vat;
    private boolean stockable;

    @ManyToMany(mappedBy = "productSet",cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    Set<Order> orders ;
}
