package com.jotace.inventory_project.service;

import com.jotace.inventory_project.model.database.Product;
import com.jotace.inventory_project.model.request.ProductRequest;
import com.jotace.inventory_project.model.request.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @Autowired
    public ProductService(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    private static final String TABLE_NAME = "Products";

    public ProductResponse save(ProductRequest productRequest) {
        var product = new Product(productRequest);
        var productTable = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(Product.class));
        productTable.putItem(product);
        return new ProductResponse(product);
    }

    public ProductResponse findById(String id) {
        var productTable = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(Product.class));
        var product = productTable.getItem(Key.builder().partitionValue(id).build());

        return new ProductResponse(product);
    }

    public void delete(String id) {
        var productTable = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(Product.class));
        productTable.deleteItem(Key.builder().partitionValue(id).build());
    }

    public List<ProductResponse> findAll() {
        var productTable = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(Product.class));

        var listProduct = productTable.scan();

        return StreamSupport.stream(listProduct.items().spliterator(), false)
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
}
