package com.codecool.supplier;

import com.codecool.customers.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(supplierMapper::mapEntityToDTO).toList();
    }

    public SupplierDTO getSupplierById(UUID id) {
        return supplierRepository.findById(id).map(supplierMapper::mapEntityToDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public SupplierDTO createSupplier(SupplierRequestDTO supplierDTO) {
        try {
            var newCustomer = supplierMapper.mapDTOToEntity(supplierDTO);
            var savedCustomer = supplierRepository.save(newCustomer);
            return supplierMapper.mapEntityToDTO(savedCustomer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to save customer", e);
        }
    }

    public SupplierDTO updateSupplier(UUID id, SupplierRequestDTO supplierDTO) {
        Supplier supplierFromDB = supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        supplierFromDB.setName(supplierDTO.name());
        supplierFromDB.setEmail(supplierDTO.email());
        supplierFromDB.setPhoneNumber(supplierDTO.phoneNumber());

        Supplier updatedSupplier = supplierRepository.save(supplierFromDB);
        return supplierMapper.mapEntityToDTO(updatedSupplier);
    }

    public void deleteSupplier(UUID id) {
        supplierRepository.deleteById(id);
    }
}
