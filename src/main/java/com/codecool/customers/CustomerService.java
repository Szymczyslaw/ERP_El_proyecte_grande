package com.codecool.customers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::mapEntityToDTO)
                .toList();
    }
    public CustomerDTO getCustomer(UUID id) {
        return customerRepository.findById(id)
                .map(customerMapper::mapEntityToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CustomerDTO addCustomer(CustomerRequestDTO dto) {
        try {
            var newCustomer = customerMapper.mapDTOTOEntity(dto);
            var savedCustomer = customerRepository.save(newCustomer);
            return customerMapper.mapEntityToDTO(savedCustomer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to save customer", e);
        }
    }

    public CustomerDTO updateCustomer(UUID id, CustomerRequestDTO dto) {
        Customer customerFromDB = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        customerFromDB.setAddress(dto.address());
        customerFromDB.setFirstName(dto.firstName());
        customerFromDB.setLastName(dto.lastName());
        customerFromDB.setEmail(dto.email());
        customerFromDB.setPhoneNumber(dto.phoneNumber());

        Customer updatedCustomer = customerRepository.save(customerFromDB);
        return customerMapper.mapEntityToDTO(updatedCustomer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

}
