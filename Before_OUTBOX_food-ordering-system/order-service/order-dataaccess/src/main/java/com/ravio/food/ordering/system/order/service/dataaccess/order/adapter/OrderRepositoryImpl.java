package com.ravio.food.ordering.system.order.service.dataaccess.order.adapter;

import com.ravio.food.ordering.system.domain.valueobject.OrderId;
import com.ravio.food.ordering.system.order.service.dataaccess.order.mapper.OrderDataAccessMapper;
import com.ravio.food.ordering.system.order.service.dataaccess.order.repository.OrderJpaRepository;
import com.ravio.food.ordering.system.order.service.domain.entity.Order;
import com.ravio.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.ravio.food.ordering.system.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository, OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

   @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderJpaRepository.findById(orderId.getValue()).map(orderDataAccessMapper::orderEntityToOrder);
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}
