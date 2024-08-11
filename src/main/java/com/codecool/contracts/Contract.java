package com.codecool.contracts;

import com.codecool.customers.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
public class Contract {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    @Positive(message = "Gross price must be positive")
    private double grossPrice;
    @Positive(message = "Net price must be positive")
    private double netPrice;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Version
    private Integer version;


    public Contract(double grossPrice, double netPrice) {
        this.grossPrice = grossPrice;
        this.netPrice = netPrice;
    }
    public void assignCustomer(Customer customer){
        this.customer = customer;
    }
}
