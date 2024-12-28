package com.ravio.food.ordering.system.order.service.domain.ports.output.message.publisher.payment;

import com.ravio.food.ordering.system.domain.events.publisher.DomainEventPublisher;
import com.ravio.food.ordering.system.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
