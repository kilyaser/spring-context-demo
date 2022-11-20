package com.gb.spring;

import java.util.Optional;

public interface ProductRepository<T> {

    Iterable<T> findAll();
    Optional<T> findById(int id);
    void addProduct(T name);



}
