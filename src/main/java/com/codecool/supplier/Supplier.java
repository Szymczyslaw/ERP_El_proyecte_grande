package com.codecool.supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Supplier {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    @NotBlank(message = "Name of the company cannot be empty")
    private String name;
    private String email;
    private String phoneNumber;

    public Supplier(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}