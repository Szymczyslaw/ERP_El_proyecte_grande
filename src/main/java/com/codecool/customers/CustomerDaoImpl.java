package com.codecool.customers;

import com.codecool.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void addCustomer(Customer customer) {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.ADD_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
            System.out.println(Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEMail());
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
    public void deleteCustomer() {

    }

    @Override
    public void updateCustomer() {

    }

    @Override
    public void getCustomer() {

    }

    @Override
    public void getAllCustomers() {

    }
}
