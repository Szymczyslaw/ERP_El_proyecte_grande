package com.codecool.customers;

import jakarta.validation.Valid;
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

    public Customer mapDTOTOEntity(@Valid CustomerRequestDTO dto) {
        return new Customer(
          dto.name(),
          dto.email(),
          dto.phoneNumber(),
          dto.address(),
          dto.contractList()
        );
    }
}
