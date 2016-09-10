package com.odeal;

import com.odeal.entity.Product;
import com.odeal.service.ProductService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTests {


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    ProductService productService;

    Product testProduct;
    static Long testId;


    @BeforeClass
    public static void userServiceInitial() {
        // Before Test initializing

    }

    @Before
    public void userServiceBefore() {
        testProduct = new Product();
        testProduct.setName("Arayüz hazırlanması");
        testProduct.setDescription("arayüz açıklaması");
    }

    @Test
    public void test1_create() {
        Product savedProduct = productService.create(testProduct);
        Assert.assertNotNull("Could not record", savedProduct);
        testId = savedProduct.getId();
    }


    @Test
    public void test2_listAll() {
        Iterable<Product> todos = productService.listAll();
        Assert.assertNotNull("Not found user list", todos);
    }


    @Test
    public void test3_findById() {
        Product product = productService.findById(testId);
        Assert.assertNotNull("Not found user", product);
    }


    @Test
    public void test4_update() {
        Product savedProduct = productService.findById(testId);

        Product updatedProduct = productService.update(savedProduct);
        Assert.assertNotNull("Not update todo", updatedProduct);
    }

    @Test
    public void test5_delete() {
        productService.delete(testId);
    }

}
