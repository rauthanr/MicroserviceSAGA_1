package com.ravio.food.ordering.system.order.service.domain;

import com.ravio.food.ordering.system.domain.events.publisher.DomainEventPublisher;
import com.ravio.food.ordering.system.order.service.domain.entity.Order;
import com.ravio.food.ordering.system.order.service.domain.entity.Restaurant;
import com.ravio.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.ravio.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.ravio.food.ordering.system.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages, DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher);

    void cancelOrder(Order order, List<String> failureMessages);
}
