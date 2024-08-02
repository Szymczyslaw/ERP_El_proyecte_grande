package com.codecool.service;

import com.codecool.dto.SupplierDTO;
import com.codecool.entity.Supplier;
import com.codecool.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Convert Entity to DTO
    private SupplierDTO convertToDTO(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setEmail(supplier.getEmail());
        dto.setPhoneNumber(supplier.getPhoneNumber());
        return dto;
    }

    // Convert DTO to Entity
    private Supplier convertToEntity(SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setName(dto.getName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhoneNumber(dto.getPhoneNumber());
        return supplier;
    }

    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(this::convertToDTO).toList();
    }

    public SupplierDTO getSupplierById(int id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.map(this::convertToDTO).orElse(null);
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = convertToEntity(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return convertToDTO(savedSupplier);
    }

    public SupplierDTO updateSupplier(int id, SupplierDTO supplierDTO) {
        if (supplierRepository.existsById(id)) {
            Supplier supplier = convertToEntity(supplierDTO);
            supplier.setId(id); // Ensure the ID is set correctly
            Supplier updatedSupplier = supplierRepository.save(supplier);
            return convertToDTO(updatedSupplier);
        }
        return null; // Or throw an exception if preferred
    }

    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }
}
