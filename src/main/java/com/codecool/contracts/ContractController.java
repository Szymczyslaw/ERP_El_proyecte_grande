package com.codecool.contracts;

import com.codecool.customers.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<ContractDTO> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ContractDTO getContractById(@PathVariable UUID id) {
        return contractService.getContract(id);
    }

    @PostMapping
    public ContractDTO addContract(@RequestBody @Valid ContractRequestDTO dto) {
        return contractService.addContract(dto);
    }
    @PutMapping("/{id}")
    public CustomerDTO updateContract(@PathVariable UUID id, @Valid @RequestBody ContractRequestDTO dto){
        return contractService.updateContract(id, dto);
    }
    @PutMapping("/{contractId}/customers/{customerId}")
    public void assignContractToUser(@PathVariable UUID contractId, @PathVariable UUID customerId){
        contractService.assignContractToDeveloper(contractId, customerId);
    }
}
