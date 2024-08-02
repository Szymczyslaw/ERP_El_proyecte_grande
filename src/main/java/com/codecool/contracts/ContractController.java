package com.codecool.contracts;

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

}
