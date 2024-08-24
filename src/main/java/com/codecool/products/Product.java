package com.codecool.products;

import com.codecool.contracts.Contract;
import com.codecool.supplier.Supplier;
import com.codecool.customers.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    @NotBlank(message = "Name of the product cannot be empty")
    private String name;
    @Positive(message = "Price of the product must be positive")
    private int price;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "product")
    private List<Supplier> supplierList;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "product")
    private List<Contract> contractList;

    public Product(String name, int price, List<Supplier> suppliers, List<Contract> contracts) {
        this.name = name;
        this.price = price;
        this.supplierList = suppliers != null ? suppliers : new ArrayList<>();
        this.contractList = contracts != null ? contracts : new ArrayList<>();
    }

    public void addSupplier(Supplier supplier) {
        supplierList.add(supplier);
    }

    public void addContract(Contract contract) {
        contractList.add(contract);
    }


}