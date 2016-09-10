package com.odeal.rest;

import com.odeal.dto.ProductDto;
import com.odeal.dto.Response;
import com.odeal.entity.Product;
import com.odeal.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hikuley on 09/09/16.
 */

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    protected ProductService productService;

    @Autowired
    protected ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    private Response create(@RequestBody @Valid ProductDto productDto, BindingResult bindingResult) {
        log.debug("REST request to create product : {}", productDto);

        Response response = new Response();
        if (!bindingResult.hasErrors()) {
            Product product = modelMapper.map(productDto, Product.class);
            Product savedProduct = productService.create(product);
            response.setData(savedProduct);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Created product successfully");
            return response;
        } else {
            response.setFieldErrors(bindingResult.getFieldErrors());
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Can not created product");
            return response;
        }
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable(value = "productId") Long id) {
        log.debug("REST request to delete product  productId:", id);

        productService.delete(id);
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Deleted successfully");
        return response;
    }


    @RequestMapping(method = RequestMethod.PUT)
    private Response update(@RequestBody @Valid ProductDto productDto, BindingResult bindingResult) {
        log.debug("REST request to update product : {}", productDto);

        Response response = new Response();
        if (!bindingResult.hasErrors()) {
            Product product = modelMapper.map(productDto, Product.class);
            Product savedProduct = productService.update(product);
            response.setData(savedProduct);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Successfully update product");
            return response;
        } else {
            response.setFieldErrors(bindingResult.getFieldErrors());
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Can not update product");
            return response;
        }
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Response read(@PathVariable(value = "productId") Long productId) {
        log.debug("REST request to read one product by productId: {}", productId);

        Response response = new Response();
        if (productId != null) {
            Product product = productService.findById(productId);
            ProductDto productDto = modelMapper.map(product, ProductDto.class);

            response.setStatus(HttpStatus.OK);
            response.setData(productDto);
            response.setMessage("Read product");
        } else {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Require Product ID");
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response listAll() {
        log.debug("REST request to read all product.");

        Response response = new Response();
        List<Product> products = productService.listAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<ProductDto>>() {
        }.getType();
        List<ProductDto> productDtos = modelMapper.map(products, targetListType);

        response.setData(productDtos);
        response.setStatus(HttpStatus.OK);
        response.setMessage("Read all products");
        return response;
    }


}
