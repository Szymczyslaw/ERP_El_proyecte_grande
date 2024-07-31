package com.codecool.contracts;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Contract {
    @Id
    private UUID id = UUID.randomUUID();
    @NotBlank(message = "Gross price cannot be empty")
    private double grossPrice;
    @NotBlank(message = "Net price cannot be empty")
    private double netPrice;
    @NotBlank(message = "Customer id cannot be empty")
    private UUID customerId;
    @Version
    private Integer version;

    public Contract(double v, double v1, UUID uuid) {
    }
}
