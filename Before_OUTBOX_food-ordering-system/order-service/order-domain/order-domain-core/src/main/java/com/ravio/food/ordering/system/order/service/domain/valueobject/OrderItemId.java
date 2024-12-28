package com.ravio.food.ordering.system.order.service.domain.valueobject;

import com.ravio.food.ordering.system.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
