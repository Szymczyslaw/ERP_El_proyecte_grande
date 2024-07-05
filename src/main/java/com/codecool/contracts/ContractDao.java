package com.codecool.contracts;

import java.sql.SQLException;
import java.util.List;

public interface ContractDao {
    void addContract(Contract contract) throws SQLException;

    void deleteContract(long contractId) throws SQLException;

    void updateContract(Contract contract) throws SQLException;

    Contract getContract(long contractId) throws SQLException;

    List<Contract> getAllContracts() throws SQLException;
}
