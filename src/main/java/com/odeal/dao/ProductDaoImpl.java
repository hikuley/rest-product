package com.odeal.dao;

import com.odeal.entity.Product;
import com.odeal.utility.GenericDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hikuley on 27/08/16.
 */

@Repository
@Transactional
@Qualifier(value = "productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

}
