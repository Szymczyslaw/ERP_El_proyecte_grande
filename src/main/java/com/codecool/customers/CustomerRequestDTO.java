package com.codecool.customers;

import com.codecool.contracts.Contract;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.util.List;

public record CustomerRequestDTO(
        @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
        @NotBlank(message = "Name cannot be empty")
        String name,
        @Email
        @NotBlank(message = "E-mail address cannot be empty")
        String email,
        @Range(min = 9, max = 11)
        @NotBlank(message = "Phone number cannot be empty")
        int phoneNumber,
        @NotBlank(message = "Address number cannot be empty")
        String address,
        List<Contract> contractList
) {
}
