package com.codecool.contracts;

import com.codecool.customers.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Positive(message = "Gross price must be positive")
    private double grossPrice;
    @Positive(message = "Net price must be positive")
    private double netPrice;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Customer cannot be null")
    private Customer customer;
    @Version
    private Integer version;


    public Contract(double grossPrice, double netPrice, Customer customer) {
        this.grossPrice = grossPrice;
        this.netPrice = netPrice;
        this.customer = customer;
    }
}
