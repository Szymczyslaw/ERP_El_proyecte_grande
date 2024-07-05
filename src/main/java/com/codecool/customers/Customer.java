package com.codecool.customers;

import com.codecool.contracts.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private final List<Contract> contractList = new ArrayList<>();


}
