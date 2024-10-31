package com.jotace.inventory_project.model.database;

import com.jotace.inventory_project.model.request.ProductRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@DynamoDbBean
public class Product {

    private String id;

    private String name;
    private BigDecimal price;
    private String description;

    public Product(ProductRequest productRequest) {
        this.id = UUID.randomUUID().toString();
        this.name = productRequest.name();
        this.price = productRequest.price();
        this.description = productRequest.description();
    }

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    @DynamoDbAttribute("price")
    public BigDecimal getPrice() {
        return price;
    }

    @DynamoDbAttribute("description")
    public String getDescription() {
        return description;
    }
}
