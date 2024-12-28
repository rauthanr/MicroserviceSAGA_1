package com.ravio.food.ordering.system.restaurant.service.domain.dto;

import com.ravio.food.ordering.system.domain.valueobject.RestaurantOrderStatus;
import com.ravio.food.ordering.system.restaurant.service.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalRequest {

    private String id;
    private String sagaId;
    private String restaurantId;
    private String orderId;
    private RestaurantOrderStatus restaurantOrderStatus;
    private java.util.List<Product> products;
    private java.math.BigDecimal price;
    private java.time.Instant createdAt;
}
