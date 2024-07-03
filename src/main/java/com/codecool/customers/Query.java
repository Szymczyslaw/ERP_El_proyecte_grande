package com.codecool.customers;

public class Query {
    public static final String ADD_CUSTOMER = "INSERT INTO customer (name, email, phone_number, address) VALUES (?,?,?,?)";
    public static final String UPDATE_CUSTOMER = "UPDATE customer SET id";

}
