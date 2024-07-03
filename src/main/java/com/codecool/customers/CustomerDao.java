package com.codecool.customers;

public interface CustomerDao {
    public void addCustomer(Customer customer);

    void deleteCustomer();

    void updateCustomer();

    void getCustomer();

    void getAllCustomers();
}
