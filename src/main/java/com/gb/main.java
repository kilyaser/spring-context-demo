package com.gb;

import com.gb.spring.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@Slf4j
public class main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.gb.config");
        Cart cart = context.getBean(Cart.class);
        cart.addProductById(1);
        cart.addProductById(2);
        cart.removeProductById(1);

        Cart cart2 = context.getBean(Cart.class);
        cart2.addProductById(3);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(b -> log.info("{}", b));


    }
}
