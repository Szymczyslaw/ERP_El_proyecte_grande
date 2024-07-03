package com.codecool.customers;

import com.codecool.contracts.Contract;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Customer {
    private long id;
    private String name;
    private String eMail;
    private int phoneNumber;
    private String address;
    private final List<Contract> contractList = new ArrayList<>();

}
