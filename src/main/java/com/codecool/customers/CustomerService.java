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
            // Log the exception or handle it accordingly
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to save customer", e);
        }
    }

//    public CustomerDTO updateCustomer(UUID id, CustomerRequestDTO customer) {
//        Customer customerFromDB = customerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Contract {id} not found"));
//
//        customerFromDB.setAddress(customer.getAddress());
//        customerFromDB.setName(customer.getName());
//        customerFromDB.setEmail(customer.getEmail());
//        customerFromDB.setPhoneNumber(customer.getPhoneNumber());
//
//        customerRepository.save(customerFromDB);
//        return null;
//    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

}