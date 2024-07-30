package com.codecool.contracts;

import java.util.UUID;

public record ContractDTO(
        UUID id,
        double grossPrice,
        double netPrice,
        UUID customerId
) {

}
