package com.codecool.contracts;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
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
    private double grossPrice;
    private double netPrice;
    private UUID customerId;
    @Version
    private Integer version;
}
