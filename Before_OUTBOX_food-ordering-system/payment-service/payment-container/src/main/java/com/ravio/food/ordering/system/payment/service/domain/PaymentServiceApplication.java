package com.ravio.food.ordering.system.payment.service.domain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ravio.food.ordering.system.payment.service.dataaccess")
@EntityScan(basePackages = "com.ravio.food.ordering.system.payment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.ravio.food.ordering.system")
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

}
