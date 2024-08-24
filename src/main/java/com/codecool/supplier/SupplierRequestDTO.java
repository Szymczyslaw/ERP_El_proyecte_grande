package com.codecool.supplier;

import com.codecool.contracts.Contract;
import jakarta.validation.constraints.*;

public record SupplierRequestDTO(
    @NotBlank(message = "Name of the company cannot be empty")
    String name,
    @NotBlank(message = "E-mail address cannot be empty")
    String email,
    @Size(min = 9, max = 15, message = "Phone number must be between 9 and 15 characters")
    @NotBlank(message = "Phone number cannot be empty")
    String phoneNumber
    ){

}
