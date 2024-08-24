package com.codecool.products;

import com.codecool.contracts.Contract;
import com.codecool.supplier.Supplier;

import java.util.UUID;

public record ProductDTO(
        UUID id,
        String name,
        int price,
        Supplier supplier,
        Contract contractId
) {

}
