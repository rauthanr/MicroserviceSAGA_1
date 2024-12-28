package com.ravio.food.ordering.system.restaurant.service.exception;

import com.ravio.food.ordering.system.domain.exception.DomainException;

public class RestaurantDomainException extends DomainException {

    public RestaurantDomainException(String message) {
        super(message);
    }

    public RestaurantDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
