package com.odeal.rest;

import com.odeal.dto.ProductOrderDto;
import com.odeal.dto.Response;
import com.odeal.entity.ProductOrder;
import com.odeal.service.ProductOrderService;
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
@RequestMapping(value = "/order")
public class ProductOrderController {

    private final Logger log = LoggerFactory.getLogger(ProductOrderController.class);

    @Autowired
    protected ProductOrderService productOrderService;

    @Autowired
    protected ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST)
    private Response create(@RequestBody @Valid ProductOrderDto productOrderDto, BindingResult bindingResult) {
        log.debug("REST request to create order : {}", productOrderDto);

        Response response = new Response();
        if (!bindingResult.hasErrors()) {
            ProductOrder productOrder = modelMapper.map(productOrderDto, ProductOrder.class);
            ProductOrder savedProductOrder = productOrderService.create(productOrder);
            response.setData(savedProductOrder);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Created productOrder successfully");
            return response;
        } else {
            response.setFieldErrors(bindingResult.getFieldErrors());
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Can not created order");
            return response;
        }
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable(value = "orderId") Long id) {
        log.debug("REST request to delete order  orderId:", id);

        productOrderService.delete(id);
        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        response.setMessage("Deleted successfully");
        return response;
    }

    @RequestMapping(method = RequestMethod.PUT)
    private Response update(@RequestBody @Valid ProductOrderDto productOrderDto, BindingResult bindingResult) {
        log.debug("REST request to update order : {}", productOrderDto);

        Response response = new Response();
        if (!bindingResult.hasErrors()) {
            ProductOrder order = modelMapper.map(productOrderDto, ProductOrder.class);
            ProductOrder orderSaved = productOrderService.update(order);
            response.setData(orderSaved);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Successfully update order");
            return response;
        } else {
            response.setFieldErrors(bindingResult.getFieldErrors());
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Can not update order");
            return response;
        }
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Response read(@PathVariable(value = "orderId") Long productId) {
        log.debug("REST request to read one order by orderId: {}", productId);

        Response response = new Response();
        if (productId != null) {
            ProductOrder productOrder = productOrderService.findById(productId);
            ProductOrderDto productOrderDto = modelMapper.map(productOrder, ProductOrderDto.class);

            response.setStatus(HttpStatus.OK);
            response.setData(productOrderDto);
            response.setMessage("Read productOrder");
        } else {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Require order ID");
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response listAll() {
        log.debug("REST request to read all product.");

        Response response = new Response();
        List<ProductOrder> productOrderList = productOrderService.listAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<ProductOrderDto>>() {
        }.getType();
        List<ProductOrderDto> productOrderDtoList = modelMapper.map(productOrderList, targetListType);

        response.setData(productOrderDtoList);
        response.setStatus(HttpStatus.OK);
        response.setMessage("Read all orders");
        return response;
    }


}
