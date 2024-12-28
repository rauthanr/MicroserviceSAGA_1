package com.ravio.food.ordering.system.restaurant.service.domain;

import com.ravio.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.ravio.food.ordering.system.restaurant.service.domain.port.input.message.listener.RestaurantApprovalRequestMessageListener;
import com.ravio.food.ordering.system.restaurant.service.event.OrderApprovalEvent;

public class RestaurantApprovalRequestMessageListenerImpl implements RestaurantApprovalRequestMessageListener {

    private final RestaurantApprovalRequestHelper restaurantApprovalRequestHelper;

    public RestaurantApprovalRequestMessageListenerImpl(RestaurantApprovalRequestHelper
                                                                restaurantApprovalRequestHelper) {
        this.restaurantApprovalRequestHelper = restaurantApprovalRequestHelper;
    }

    @Override
    public void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest) {
        OrderApprovalEvent orderApprovalEvent =
                restaurantApprovalRequestHelper.persistOrderApproval(restaurantApprovalRequest);
        orderApprovalEvent.fire();
    }
}
