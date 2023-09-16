package com.playtable.customer.service;

import com.playtable.customer.domain.entity.Customer;
import com.playtable.customer.domain.request.CustomerRequest;
import com.playtable.customer.domain.response.CustomerResponse;
import com.playtable.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = request.toEntity();
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerResponse.fromEntity(savedCustomer);
    }

    public CustomerResponse getCustomer(UUID userId) {
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + userId));
        return CustomerResponse.fromEntity(customer);
    }

    public CustomerResponse updateCustomer(UUID userId, CustomerRequest request) {
        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + userId));
        customer.update(request);
        return CustomerResponse.fromEntity(customerRepository.save(customer));
    }

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteCustomer(UUID userId) {
        customerRepository.deleteById(userId);
    }
}
