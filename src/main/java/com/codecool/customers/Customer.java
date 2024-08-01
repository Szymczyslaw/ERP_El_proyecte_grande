package com.codecool.customers;

import com.codecool.contracts.Contract;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    private UUID id = UUID.randomUUID();
    @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Email
    @NotBlank(message = "E-mail address cannot be empty")
    private String email;
    @Size(min = 9, max = 15, message = "Phone number must be between 9 and 15 characters")
    @NotBlank(message = "Phone number cannot be empty")
    private String phoneNumber;
    @NotBlank(message = "Address number cannot be empty")
    private String address;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "customer"
    )
    private List<Contract> contractList;
    @Version
    private Integer version;


    public Customer(String name, String email, String phoneNumber, String address, List<Contract> contracts) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.contractList = contracts != null ? contracts : new ArrayList<>();
    }
}
