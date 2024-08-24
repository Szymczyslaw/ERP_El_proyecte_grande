package com.codecool.products;

import com.codecool.contracts.Contract;
import com.codecool.supplier.Supplier;
import jakarta.validation.constraints.*;

import java.util.List;

public record ProductRequestDTO(
        @NotBlank(message = "Name of the company cannot be empty")
        String name,
        @Positive(message = "price of the product ust be positive")
        int Price,
        List<Supplier> supplierList,
        List<Contract> contractList

) {
}
