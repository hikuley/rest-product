package com.odeal.dto;

import java.util.Calendar;

/**
 * Created by hikuley on 09/09/16.
 */

public class ProductOrderDto extends BaseDto {

    private Integer quantity;

    private Double discount;

    private Calendar orderDate;

    private Calendar shippedDate;

    private Double amount;

    private String shipName;

    private String shipRegion;

    private String city;

    private ProductDto product;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Calendar getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Calendar shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
