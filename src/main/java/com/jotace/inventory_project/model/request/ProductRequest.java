package com.jotace.inventory_project.model.request;

import java.math.BigDecimal;

public record ProductRequest(
        String name,
        BigDecimal price,
        String description
) {
}
