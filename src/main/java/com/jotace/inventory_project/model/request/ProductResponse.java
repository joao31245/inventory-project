package com.jotace.inventory_project.model.request;

import com.jotace.inventory_project.model.database.Product;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        BigDecimal price,

        Long stock,
        String description) {
    public ProductResponse(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getDescription());
    }
}
