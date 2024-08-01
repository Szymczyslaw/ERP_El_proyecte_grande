package com.codecool.contracts;

import com.codecool.customers.Customer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ContractRequestDTO(
        @Positive(message = "Gross price must be positive")
        double grossPrice,
        @Positive(message = "Net price must be positive")
        double netPrice,
        @NotNull(message = "Customer cannot be null")
        Customer customer
) {
}
