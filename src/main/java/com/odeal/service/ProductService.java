package com.odeal.service;

import com.odeal.entity.Product;

import java.util.List;

/**
 * Created by hikuley on 09/09/16.
 */
public interface ProductService {

    Product create(Product product);

    List<Product> listAll();

    Product findById(Long id);

    void delete(Long id);

    Product update(Product product);

}
