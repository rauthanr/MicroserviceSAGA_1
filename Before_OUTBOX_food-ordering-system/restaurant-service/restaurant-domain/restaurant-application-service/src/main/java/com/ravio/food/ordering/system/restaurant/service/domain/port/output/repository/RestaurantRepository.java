package com.ravio.food.ordering.system.restaurant.service.domain.port.output.repository;

import com.ravio.food.ordering.system.restaurant.service.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
