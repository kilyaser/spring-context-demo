package com.gb.config;

import com.gb.spring.Cart;
import com.gb.spring.ProductRepositoryImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
    @Bean
    public ProductRepositoryImpl productRepository() {
        return new ProductRepositoryImpl();
    }
    @Bean
    public Cart cart(){
        return new Cart(productRepository());
    }
}
