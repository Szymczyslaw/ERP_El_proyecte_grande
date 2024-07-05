package com.codecool.contracts;

import com.codecool.DatabaseUtil;
import com.codecool.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDaoImpl implements ContractDao {
    @Override
    public void addContract(Contract contract) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.ADD_CONTRACT, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, contract.getGrossPrice());
            statement.setDouble(2, contract.getNetPrice());
            statement.setLong(3, contract.getCustomerId());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contract.setId(generatedKeys.getLong(1));
                }
            }
        }
    }

    @Override
    public void deleteContract(long contractId) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.DELETE_CONTRACT);
            statement.setLong(1, contractId);
            statement.executeUpdate();
        }
    }

    @Override
    public void updateContract(Contract contract) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.UPDATE_CONTRACT);
            statement.setDouble(1, contract.getGrossPrice());
            statement.setDouble(2, contract.getNetPrice());
            statement.setLong(3, contract.getCustomerId());
            statement.setLong(4, contract.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public Contract getContract(long contractId) throws SQLException {
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(Query.GET_CONTRACT);
                statement.setLong(1, contractId);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        Contract contract = new Contract();
                        contract.setId(rs.getLong("id"));
                        contract.setGrossPrice(rs.getDouble("gross_price"));
                        contract.setNetPrice(rs.getDouble("net_price"));
                        contract.setCustomerId(rs.getLong("customer_id"));
                        return contract;
                    }
                }
            }
            return null;
        }

    @Override
    public List<Contract> getAllContracts() throws SQLException {
        List<Contract> contracts = new ArrayList<>();
        try (Connection conn = DatabaseUtil.connect().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(Query.GET_ALL_CONTRACTS);

                while (rs.next()) {
                    Contract contract = new Contract();
                    contract.setId(rs.getLong("id"));
                    contract.setGrossPrice(rs.getDouble("gross_price"));
                    contract.setNetPrice(rs.getDouble("net_price"));
                    contract.setCustomerId(rs.getLong("customer_id"));
                    contracts.add(contract);
                }
            }
            return contracts;
        }
    }
