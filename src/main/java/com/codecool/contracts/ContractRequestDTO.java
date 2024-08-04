package com.codecool.contracts;

import jakarta.validation.constraints.Positive;

public record ContractRequestDTO(
        @Positive(message = "Gross price must be positive")
        double grossPrice,
        @Positive(message = "Net price must be positive")
        double netPrice
) {
}
