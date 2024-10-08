package com.codecool.customers;

import com.codecool.contracts.Contract;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CustomerRequestDTO(
        @Size(min = 3, max = 20, message = "Name must be between 5 and 50 characters")
        @NotBlank(message = "Name cannot be empty")
        String firstName,
        @Size(min = 3, max = 20, message = "Name must be between 5 and 50 characters")
        @NotBlank(message = "Name cannot be empty")
        String lastName,
        @Email(message = "Incorrect e-mail address")
//        @Column(unique = true)
        @NotBlank(message = "E-mail address cannot be empty")
        String email,
        @Size(min = 9, max = 15, message = "Phone number must be between 9 and 15 characters")
        @NotBlank(message = "Phone number cannot be empty")
        String phoneNumber,
        @NotBlank(message = "Address cannot be empty")
        String address,
        List<Contract> contractList
) {

}
