package com.codecool.contracts;

import com.codecool.customers.Customer;

import java.util.UUID;

public record ContractDTO(
        UUID id,
        double grossPrice,
        double netPrice,
        Customer customer
) {

}
