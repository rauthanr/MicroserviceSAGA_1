package com.ravio.food.ordering.system.restaurant.service.doamin;

import com.ravio.food.ordering.system.restaurant.service.RestaurantDomainService;
import com.ravio.food.ordering.system.restaurant.service.RestaurantDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RestaurantDomainService restaurantDomainService() {
        return new RestaurantDomainServiceImpl();
    }
}
