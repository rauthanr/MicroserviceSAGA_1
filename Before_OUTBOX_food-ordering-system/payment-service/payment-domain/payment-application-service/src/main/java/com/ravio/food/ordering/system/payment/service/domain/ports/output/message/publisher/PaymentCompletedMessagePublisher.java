package com.ravio.food.ordering.system.payment.service.domain.ports.output.message.publisher;

import com.ravio.food.ordering.system.domain.events.publisher.DomainEventPublisher;
import com.ravio.food.ordering.system.payment.service.domain.event.PaymentCompletedEvent;

public interface PaymentCompletedMessagePublisher extends DomainEventPublisher<PaymentCompletedEvent> {
}