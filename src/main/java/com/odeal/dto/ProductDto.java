package com.odeal.dto;

import com.odeal.entity.enums.ProductStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hikuley on 09/09/16.
 */

public class ProductDto extends BaseDto {


    public static final int NAME_MIN_LENGTH = 4;
    public static final int NAME_MAX_LENGTH = 50;

    public static final int DESC_MIN_LENGTH = 4;
    public static final int DESC_MAX_LENGTH = 50;


    @NotNull
    @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH)
    private String name;

    @NotNull
    private Double amount;

    @NotNull
    @Size(min = DESC_MIN_LENGTH, max = DESC_MAX_LENGTH)
    private String description;

    private ProductStatus status;

    @NotNull
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
