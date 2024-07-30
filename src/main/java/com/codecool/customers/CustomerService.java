package com.codecool.customers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(entity -> new CustomerDTO(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getPhoneNumber(),
                        entity.getAddress(),
                        entity.getContractList()
                )).toList();
    }

    private void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(UUID id) {
        return customerRepository.findById(id);
    }

    public void updateCustomer(UUID id, Customer customer) {
        Customer customerFromDB = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract {id} not found"));

        customerFromDB.setAddress(customer.getAddress());
        customerFromDB.setName(customer.getName());
        customerFromDB.setEmail(customer.getEmail());
        customerFromDB.setPhoneNumber(customer.getPhoneNumber());

        customerRepository.save(customerFromDB);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

}
