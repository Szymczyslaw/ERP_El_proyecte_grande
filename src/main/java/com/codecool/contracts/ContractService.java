package com.codecool.contracts;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll().stream()
                .map(entity -> new ContractDTO(
                        entity.getId(),
                        entity.getGrossPrice(),
                        entity.getGrossPrice(),
                        entity.getCustomerId()
                )).toList();

    }

    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }

    public Optional<Contract> getContract(UUID id) {
        return contractRepository.findById(id);
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
