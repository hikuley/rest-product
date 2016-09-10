package com.odeal.service;

import com.odeal.dao.ProductOrderDao;
import com.odeal.entity.ProductOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hikuley on 08/09/16.
 */


@Service
@Qualifier(value = "productOrderService")
public class ProductOrderServiceImpl implements ProductOrderService {


    /*
    *
    * this class using for business logic with related orders
    *
    * */

    private final Logger log = LoggerFactory.getLogger(ProductOrderServiceImpl.class);

    @Autowired
    private ProductOrderDao productOrderDao;

    @Override
    public List<ProductOrder> listAll() {
        log.debug("order service running. listed orders");


        List<ProductOrder> productList = productOrderDao.listAll();
        return productList;
    }

    @Override
    public ProductOrder create(ProductOrder productOrder) {
        log.debug("productOrder service running. created new productOrder");

        return productOrderDao.create(productOrder);
    }

    @Override
    public ProductOrder findById(Long id) {
        log.debug("order service running. find order by id");

        return productOrderDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("order service running. deleted order by id");

        productOrderDao.delete(id);
    }

    @Override
    public ProductOrder update(ProductOrder productOrder) {
        log.debug("productOrder service running. productOrder product");

        return productOrderDao.update(productOrder);
    }
}
