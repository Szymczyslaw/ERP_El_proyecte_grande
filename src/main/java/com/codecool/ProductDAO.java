package com.codecool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public void addProduct(String name, int price, int supplierId, int contractId) {
        String sql = "INSERT INTO product (name, price, supplier_id, contract_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, supplierId);
            stmt.setInt(4, contractId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getProduct(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price: " + rs.getInt("price"));
                System.out.println("supplier ID: " + rs.getInt("supplier_id"));
                System.out.println("Contract ID: " + rs.getInt("contract_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id, String name, int price, int supplierId, int contractId) {
        String sql = "UPDATE product SET name = ?, price = ?, supplier_id = ?, contract_id = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, supplierId);
            stmt.setInt(4, contractId);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
