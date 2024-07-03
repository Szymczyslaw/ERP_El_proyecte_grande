package com.codecool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAO {

    public void addSupplier(int id, String name, String email, int phoneNumber) {
        String sql = "INSERT INTO supplier (id, name, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setInt(4, phoneNumber);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSupplier(int id) {
        String sql = "SELECT * FROM supplier WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone Number: " + rs.getInt("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSupplier(int id, String name, String email, int phoneNumber) {
        String sql = "UPDATE supplier SET name = ?, email = ?, phone_number = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, phoneNumber);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSupplier(int id) {
        String sql = "DELETE FROM supplier WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
