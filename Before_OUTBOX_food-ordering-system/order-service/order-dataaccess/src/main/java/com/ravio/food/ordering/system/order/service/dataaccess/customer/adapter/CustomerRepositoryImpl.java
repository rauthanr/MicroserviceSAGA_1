package com.ravio.food.ordering.system.order.service.dataaccess.customer.adapter;

import com.ravio.food.ordering.system.order.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.ravio.food.ordering.system.order.service.dataaccess.customer.repository.CustomerJPARepository;
import com.ravio.food.ordering.system.order.service.domain.entity.Customer;
import com.ravio.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJPARepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJPARepository customerJpaRepository,
                                  CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }

    @Transactional
    //@Override
    public Customer save(Customer customer) {
        return customerDataAccessMapper.customerEntityToCustomer(
                customerJpaRepository.save(customerDataAccessMapper.customerToCustomerEntity(customer)));
    }
}
