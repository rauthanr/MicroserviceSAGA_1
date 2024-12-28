package com.ravio.food.ordering.system.restaurant.service.dataaccess.adapter;

import com.ravio.food.ordering.system.dataaccess.restaurant.entity.RestaurantEntity;
import com.ravio.food.ordering.system.dataaccess.restaurant.repository.RestaurantJpaRepository;
import com.ravio.food.ordering.system.restaurant.service.dataaccess.mapper.RestaurantDataAccessMapper;
import com.ravio.food.ordering.system.restaurant.service.domain.port.output.repository.RestaurantRepository;
import com.ravio.food.ordering.system.restaurant.service.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final RestaurantJpaRepository restaurantJpaRepository;
    private final RestaurantDataAccessMapper restaurantDataAccessMapper;

    public RestaurantRepositoryImpl(RestaurantJpaRepository restaurantJpaRepository,
                                    RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.restaurantJpaRepository = restaurantJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public Optional<Restaurant> findRestaurantInformation(Restaurant restaurant) {
        List<UUID> restaurantProducts =
                restaurantDataAccessMapper.restaurantToRestaurantProducts(restaurant);
        Optional<List<RestaurantEntity>> restaurantEntities = restaurantJpaRepository
                .findByRestaurantIdAndProductIdIn(restaurant.getId().getValue(),
                        restaurantProducts);
        return restaurantEntities.map(restaurantDataAccessMapper::restaurantEntityToRestaurant);
    }
}
