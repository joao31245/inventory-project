package com.jotace.inventory_project.model.database;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.jotace.inventory_project.model.request.ProductRequest;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class Product {

    @DynamoDBHashKey
    private String id; // Primary key

    @DynamoDBAttribute
    private String name; // Other attributes

    @DynamoDBAttribute
    private BigDecimal price;

    @DynamoDBAttribute
    private String description;

    public Product(ProductRequest productRequest) {
        this.name = productRequest.name();
        this.price = productRequest.price();
        this.description = productRequest.description();
    }
}