package com.codecool.supplier;

import java.util.UUID;

public record SupplierDTO(
     UUID id,
     String name,
     String email,
     String phoneNumber
){
}

