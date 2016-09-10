package com.odeal.entity;

import com.odeal.entity.enums.ProductStatus;

import javax.persistence.*;

/**
 * Created by hikuley on 09/09/16.
 */


@Entity
public class Product extends BaseEntity {

    private String name;

    private Double amount;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

    private Long weight;

    private String model;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
