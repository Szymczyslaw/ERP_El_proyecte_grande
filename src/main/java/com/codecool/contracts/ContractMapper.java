package com.codecool.contracts;

import jakarta.validation.Valid;
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

    public Contract mapDTOTOEntity(@Valid ContractRequestDTO dto) {
        return new Contract(
                dto.grossPrice(),
                dto.netPrice(),
                dto.customerId()
        );
    }
}
