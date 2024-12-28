package com.ravio.food.ordering.system.domain.events.publisher;

import com.ravio.food.ordering.system.domain.events.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}