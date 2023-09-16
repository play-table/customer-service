package com.playtable.customer.controller;

import com.playtable.customer.domain.request.CustomerRequest;
import com.playtable.customer.domain.response.CustomerResponse;
import com.playtable.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
        CustomerResponse response = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable UUID userId) {
        CustomerResponse response = customerService.getCustomer(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable UUID userId,
            @RequestBody CustomerRequest request
    ) {
        CustomerResponse response = customerService.updateCustomer(userId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> responses = customerService.getAllCustomers();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID userId) {
        customerService.deleteCustomer(userId);
    }
}
