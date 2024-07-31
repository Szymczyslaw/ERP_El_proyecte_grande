package com.codecool.contracts;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ContractRequestDTO(
        @NotBlank(message = "Gross price cannot be empty")
        double grossPrice,
        @NotBlank(message = "Net price cannot be empty")
        double netPrice,
        @NotBlank(message = "Customer id cannot be empty")
        UUID customerId
) {
}
