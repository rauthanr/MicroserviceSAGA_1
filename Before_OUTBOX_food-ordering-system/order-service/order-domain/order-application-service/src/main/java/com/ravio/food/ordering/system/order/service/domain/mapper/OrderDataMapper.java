package com.ravio.food.ordering.system.order.service.domain.mapper;

import com.ravio.food.ordering.system.domain.valueobject.*;
import com.ravio.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.ravio.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.ravio.food.ordering.system.order.service.domain.dto.create.OrderAddress;
import com.ravio.food.ordering.system.order.service.domain.dto.message.CustomerModel;
import com.ravio.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.ravio.food.ordering.system.order.service.domain.entity.Order;
import com.ravio.food.ordering.system.order.service.domain.entity.OrderItem;
import com.ravio.food.ordering.system.order.service.domain.entity.Product;
import com.ravio.food.ordering.system.order.service.domain.entity.Restaurant;
import com.ravio.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.ravio.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.ravio.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.ravio.food.ordering.system.order.service.domain.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                                new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            List<com.ravio.food.ordering.system.order.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}
