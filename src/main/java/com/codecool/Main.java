package com.codecool;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        SupplierDAO supplierDAO = new SupplierDAO();

//        productDAO.addProduct(1, "Product1", 100, 1, 1);

//        productDAO.updateProduct(1, "UpdatedProduct1", 150, 2, 2);

        productDAO.getProduct(1);

        productDAO.deleteProduct(1);

        supplierDAO.updateSupplier(1,"Company", "firma@gmail.com", 123456789);

        supplierDAO.getSupplier(1);
    }
}