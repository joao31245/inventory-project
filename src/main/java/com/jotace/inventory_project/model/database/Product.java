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

    private String Id;

    private String name;
    private BigDecimal price;
    private String description;
    private Long stock;

    public Product(ProductRequest productRequest) {
        this.Id = UUID.randomUUID().toString();
        this.name = productRequest.name();
        this.price = productRequest.price();
        this.description = productRequest.description();
    }

    @DynamoDbAttribute("Id")
    @DynamoDbPartitionKey
    public String getId() {
        return Id;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    @DynamoDbAttribute("stock")
    public Long getStock() {
        return stock;
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
