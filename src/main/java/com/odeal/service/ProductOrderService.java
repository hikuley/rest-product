package com.odeal.service;

import com.odeal.entity.ProductOrder;

import java.util.List;

/**
 * Created by hikuley on 09/09/16.
 */

public interface ProductOrderService {

    ProductOrder create(ProductOrder productOrder);

    List<ProductOrder> listAll();

    ProductOrder findById(Long id);

    void delete(Long id);

    ProductOrder update(ProductOrder productOrder);

}
