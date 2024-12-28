package com.ravio.food.ordering.system.payment.service.domain.valueobject;

import com.ravio.food.ordering.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
