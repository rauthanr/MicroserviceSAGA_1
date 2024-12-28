package com.ravio.food.ordering.system.order.service.domain.ports.output.repository;

import com.ravio.food.ordering.system.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
