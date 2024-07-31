package com.codecool.customers;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO mapEntityToDTO(Customer entity) {
        return new CustomerDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getAddress(),
                entity.getContractList()
        );
    }
}
