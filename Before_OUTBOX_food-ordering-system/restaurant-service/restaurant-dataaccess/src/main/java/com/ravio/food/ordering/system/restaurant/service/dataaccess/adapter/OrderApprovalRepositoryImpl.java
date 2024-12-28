package com.ravio.food.ordering.system.restaurant.service.dataaccess.adapter;

import com.ravio.food.ordering.system.restaurant.service.dataaccess.mapper.RestaurantDataAccessMapper;
import com.ravio.food.ordering.system.restaurant.service.dataaccess.repository.OrderApprovalJpaRepository;
import com.ravio.food.ordering.system.restaurant.service.domain.port.output.repository.OrderApprovalRepository;
import com.ravio.food.ordering.system.restaurant.service.entity.OrderApproval;
import org.springframework.stereotype.Component;

@Component
public class OrderApprovalRepositoryImpl implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final RestaurantDataAccessMapper restaurantDataAccessMapper;


    public OrderApprovalRepositoryImpl(OrderApprovalJpaRepository orderApprovalJpaRepository,
                                       RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.orderApprovalJpaRepository = orderApprovalJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        return restaurantDataAccessMapper
                .orderApprovalEntityToOrderApproval(orderApprovalJpaRepository
                        .save(restaurantDataAccessMapper.orderApprovalToOrderApprovalEntity(orderApproval)));
    }
}
