package com.codecool.contracts;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    public ContractService(ContractRepository contractRepository, ContractMapper contractMapper) {
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
    }

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll().stream()
                .map(contractMapper::mapEntityToDTO)
                .toList();
    }

    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }

    public ContractDTO getContract(UUID id) {
        return contractRepository.findById(id)
                .map(contractMapper::mapEntityToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void updateContract(UUID id, Contract contract) {
        Contract contractFromDB = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract {id} not found"));

        contractFromDB.setNetPrice(contract.getNetPrice());
        contractFromDB.setGrossPrice(contract.getGrossPrice());
        contractFromDB.setCustomerId(contract.getCustomerId());

        contractRepository.save(contractFromDB);
    }

    public void deleteContract(UUID id) {
        contractRepository.deleteById(id);
    }
}
