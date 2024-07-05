package com.codecool.customers;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer) throws SQLException;

    void deleteCustomer(long customerId) throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    Customer getCustomer(long customerId) throws SQLException;

    List<Customer> getAllCustomers() throws SQLException;
}
