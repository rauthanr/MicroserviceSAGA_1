package com.ravio.food.ordering.system.restaurant.service;

import com.ravio.food.ordering.system.domain.events.publisher.DomainEventPublisher;
import com.ravio.food.ordering.system.restaurant.service.entity.Restaurant;
import com.ravio.food.ordering.system.restaurant.service.event.OrderApprovalEvent;
import com.ravio.food.ordering.system.restaurant.service.event.OrderApprovedEvent;
import com.ravio.food.ordering.system.restaurant.service.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {

    OrderApprovalEvent validateOrder(Restaurant restaurant,
                                     List<String> failureMessages,
                                     DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                     DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher);

}
