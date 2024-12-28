package com.ravio.food.ordering.system.restaurant.service.domain.port.output.repository;

import com.ravio.food.ordering.system.restaurant.service.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);
}
