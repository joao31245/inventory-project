package com.jotace.inventory_project.model.database;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.jotace.inventory_project.model.request.ProductRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Products")
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
        this.id = UUID.randomUUID().toString();
        this.name = productRequest.name();
        this.price = productRequest.price();
        this.description = productRequest.description();
    }
}