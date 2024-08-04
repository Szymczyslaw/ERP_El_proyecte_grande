package com.codecool.customers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable UUID id) {
        return customerService.getCustomer(id);
    }
    @PostMapping
    public CustomerDTO addCustomer(@Valid @RequestBody CustomerRequestDTO dto) {
        return customerService.addCustomer(dto);
    }
    @PutMapping("/{id}")
    public CustomerDTO updateConsumer(@PathVariable UUID id, @Valid @RequestBody CustomerRequestDTO dto){
        return customerService.updateCustomer(id, dto);
    }
}
