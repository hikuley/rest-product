package com.odeal.service;

import com.odeal.dao.ProductDao;
import com.odeal.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hikuley on 08/09/16.
 */


    /*
    *
    * this class using for business logic with related products
    *
    * */


@Service
@Qualifier(value = "productService")
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> listAll() {
        log.debug("list products");

        List<Product> productList = productDao.listAll();
        return productList;
    }

    @Override
    public Product create(Product product) {
        log.debug("product service running. created new product");
        return productDao.create(product);
    }

    @Override
    public Product findById(Long id) {
        log.debug("service running. find todo by id");

        return productDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("service running. deleted todo by id");

        productDao.delete(id);
    }

    @Override
    public Product update(Product product) {
        log.debug("service running. updated product");

        return productDao.update(product);
    }

}
