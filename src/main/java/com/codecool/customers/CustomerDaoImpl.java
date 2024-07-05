package com.codecool.customers;

import com.codecool.DatabaseUtil;
import com.codecool.Query;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.ADD_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setInt(3, customer.getPhoneNumber());
            statement.setString(4, customer.getAddress());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            customer.setId(resultSet.getLong(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SneakyThrows
    public void deleteCustomer(long customerId) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.DELETE_CUSTOMER);
            statement.setLong(1, customerId);
            statement.executeUpdate();
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.UPDATE_CUSTOMER);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setInt(3, customer.getPhoneNumber());
            statement.setString(4, customer.getAddress());
            statement.setLong(5, customer.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public Customer getCustomer(long customerId) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.GET_CUSTOMER);
            statement.setLong(1, customerId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("id"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhoneNumber(rs.getInt("phone_number"));
                    customer.setAddress(rs.getString("address"));
                    return customer;
                }
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            List<Customer> customers = new ArrayList<>();
            try (Statement statement = conn.createStatement();
                 ResultSet rs = statement.executeQuery(Query.GET_ALL_CUSTOMERS)) {

                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("id"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhoneNumber(rs.getInt("phone_number"));
                    customer.setAddress(rs.getString("address"));
                    customers.add(customer);
                }
            }
            return customers;
        }
    }
}
