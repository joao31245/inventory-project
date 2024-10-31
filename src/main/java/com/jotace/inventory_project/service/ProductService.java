package com.jotace.inventory_project.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.jotace.inventory_project.model.database.Product;
import com.jotace.inventory_project.model.request.ProductRequest;
import com.jotace.inventory_project.model.request.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public ProductService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void save(ProductRequest productRequest) {
        var product = new Product(productRequest);
        dynamoDBMapper.save(product);
    }


    public ProductResponse findById(String id) {
        var product = dynamoDBMapper.load(Product.class, id);
        if (product == null) {
            throw new ResourceNotFoundException("Product with ID " + id + " not found");
        }
        return new ProductResponse(product);
    }

    public void delete(String id) {
        var product = dynamoDBMapper.load(Product.class, id);
        if (product != null) {
            dynamoDBMapper.delete(product);
        } else {
            throw new ResourceNotFoundException("Product with ID " + id + " not found");
        }
    }
}
