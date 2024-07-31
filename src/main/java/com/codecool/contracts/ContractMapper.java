package com.codecool.contracts;

import org.springframework.stereotype.Component;

@Component
public class ContractMapper {
    public ContractDTO mapEntityToDTO(Contract entity) {
        return new ContractDTO(
                entity.getId(),
                entity.getGrossPrice(),
                entity.getGrossPrice(),
                entity.getCustomerId()
        );
    }
}
