package com.gb.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {
    private static Long id = 1L;
    private final List<Product> cartProduct = new ArrayList<>();

    private final ProductRepositoryImpl productRepository;
    @Autowired
    public Cart(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
        log.info("created cart #{}", id++);
    }

    public void addProductById(int id) {

        if (productRepository.findById(id).isPresent())
            cartProduct.add(productRepository.findById(id).get());
        log.info("added product id: {}, name {} to cart #{}",
                id,
                productRepository.findById(id).get().getName(),
                Cart.id);
    }
    public void removeProductById(int id) {
        cartProduct.removeIf(product -> product.getId() == id);
        log.info("removed product id: {} from cart #{}",
                id,
                Cart.id);
    }

}
