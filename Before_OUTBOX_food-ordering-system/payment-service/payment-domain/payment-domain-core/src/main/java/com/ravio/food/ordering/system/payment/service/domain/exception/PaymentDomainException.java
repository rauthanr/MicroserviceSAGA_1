package com.ravio.food.ordering.system.payment.service.domain.exception;

import com.ravio.food.ordering.system.domain.exception.DomainException;

public class PaymentDomainException extends DomainException {

    public PaymentDomainException(String message) {
        super(message);
    }

    public PaymentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
