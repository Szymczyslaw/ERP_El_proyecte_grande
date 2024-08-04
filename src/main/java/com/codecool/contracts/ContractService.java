package com.codecool.contracts;

import com.codecool.customers.Customer;
import com.codecool.customers.CustomerDTO;
import com.codecool.customers.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;
    private final CustomerRepository customerRepository;

    public ContractService(ContractRepository contractRepository, ContractMapper contractMapper, CustomerRepository customerRepository) {
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
        this.customerRepository = customerRepository;
    }

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll().stream()
                .map(contractMapper::mapEntityToDTO)
                .toList();
    }

    public ContractDTO getContract(UUID id) {
        return contractRepository.findById(id)
                .map(contractMapper::mapEntityToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ContractDTO addContract(ContractRequestDTO dto) {
        var newContract = contractMapper.mapDTOTOEntity(dto);
        var savedContract = contractRepository.save(newContract);
        return contractMapper.mapEntityToDTO(savedContract);
    }

    public CustomerDTO updateContract(UUID id, @Valid ContractRequestDTO dto) {
        Contract contractFromDB = contractRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        contractFromDB.setNetPrice(dto.netPrice());
        contractFromDB.setGrossPrice(dto.grossPrice());

        contractRepository.save(contractFromDB);
        return null;
    }

    public void deleteContract(UUID id) {
        contractRepository.deleteById(id);
    }

    public void assignContractToDeveloper(UUID contractId, UUID customerId) {
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        contract.assignCustomer(customer);
        customer.addContract(contract);
        contractRepository.save(contract);
    }
}
