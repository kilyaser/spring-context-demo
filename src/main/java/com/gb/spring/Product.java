package com.gb.spring;


import lombok.Generated;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Product {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private int id;
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.price = price;
    }


}
