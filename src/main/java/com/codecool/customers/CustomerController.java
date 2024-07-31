package com.codecool.customers;

import com.codecool.contracts.ContractDTO;
import com.codecool.contracts.ContractRequestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public CustomerRequestDTO addCustomer(CustomerRequestDTO dto) {
        customerService.addCustomer(dto);
        return dto;
    }
}
