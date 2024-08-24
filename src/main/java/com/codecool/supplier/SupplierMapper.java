package com.codecool.supplier;

import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public SupplierDTO mapEntityToDTO(Supplier entity) {
        return new SupplierDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber()
        );
    }
    public Supplier mapDTOToEntity(@Valid SupplierRequestDTO dto){
        return new Supplier(
                dto.name(),
                dto.phoneNumber(),
                dto.email()
        );
    }
}
