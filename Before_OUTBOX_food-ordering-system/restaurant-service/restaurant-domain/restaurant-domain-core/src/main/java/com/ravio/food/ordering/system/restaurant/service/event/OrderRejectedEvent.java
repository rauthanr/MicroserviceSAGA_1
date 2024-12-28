package com.ravio.food.ordering.system.restaurant.service.event;

import com.ravio.food.ordering.system.domain.events.publisher.DomainEventPublisher;
import com.ravio.food.ordering.system.domain.valueobject.RestaurantId;
import com.ravio.food.ordering.system.restaurant.service.entity.OrderApproval;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderRejectedEvent extends OrderApprovalEvent {

    private final DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher;

    public OrderRejectedEvent(OrderApproval orderApproval,
                              RestaurantId restaurantId,
                              List<String> failureMessages,
                              ZonedDateTime createdAt,
                              DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher) {
        super(orderApproval, restaurantId, failureMessages, createdAt);
        this.orderRejectedEventDomainEventPublisher = orderRejectedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderRejectedEventDomainEventPublisher.publish(this);
    }
}
