package com.codecool.customers;

import com.codecool.contracts.Contract;

import java.util.List;
import java.util.UUID;

public record CustomerDTO(
        UUID id,
        String name,
        String email,
        int phoneNumber,
        String address,
        List<Contract> contractList
) {
}
