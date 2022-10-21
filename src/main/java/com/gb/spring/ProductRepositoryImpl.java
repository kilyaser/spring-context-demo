package com.gb.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
// @Component
public class ProductRepositoryImpl implements ProductRepository<Product>{

    private final List<Product> products = new ArrayList<>();


    @Override
    public Iterable<Product> findAll() {
        log.info("request list of product");
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        log.info("request product by id {}", id);
        for (Product product : products) {
            if (product.getId() == id) return Optional.of(product);

        }
        return Optional.empty();
    }


    @Override
    public void addProduct(Product product) {
        products.add(product);
    }


    @PostConstruct
    public void init(){
        log.info("Preloading the product is starting");
        addProduct(new Product("Milk", 10.5));
        addProduct(new Product("Water", 11.5));
        addProduct(new Product("Juice", 15.5));
        addProduct(new Product("Lime", 1.5));
        addProduct(new Product("Meat", 100.5));
        log.info("Added {} items", products.size());

    }




}
