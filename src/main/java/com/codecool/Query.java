package com.codecool;

public class Query {
    public static final String ADD_CUSTOMER = "INSERT INTO customer (name, email, phone_number, address) VALUES (?,?,?,?)";
    public static final String UPDATE_CUSTOMER = "UPDATE customer SET name = ?, email = ?, phone_number = ?, address = ? WHERE id = ?";
    public static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";
    public static final String GET_CUSTOMER = "SELECT id, name, email, phone_number, address FROM customer WHERE id = ?";
    public static final String GET_ALL_CUSTOMERS = "SELECT id, name, email, phone_number, address FROM customer";


    public static final String ADD_CONTRACT = "INSERT INTO contract (price_brutto, price_netto, customer_id) VALUES (?, ?, ?)";
    public static final String UPDATE_CONTRACT = "UPDATE contract SET price_brutto = ?, price_netto = ?, customer_id = ? WHERE id = ?";
    public static final String DELETE_CONTRACT = "DELETE FROM contract WHERE id = ?";
    public static final String GET_CONTRACT = "SELECT id, price_brutto, price_netto, customer_id FROM contract WHERE id = ?";
    public static final String GET_ALL_CONTRACTS = "SELECT id, price_brutto, price_netto, customer_id FROM contract";
}
