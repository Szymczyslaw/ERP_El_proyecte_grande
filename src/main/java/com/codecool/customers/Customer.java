package com.codecool.customers;

import com.codecool.contracts.Contract;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

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
    @Range(min = 9, max = 11)
    @NotBlank(message = "Phone number cannot be empty")
    private int phoneNumber;
    @NotBlank(message = "Address number cannot be empty")
    private String address;
    @OneToMany
    private final List<Contract> contractList = new ArrayList<>();
    @Version
    private Integer version;
}
