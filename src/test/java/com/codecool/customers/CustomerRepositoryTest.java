package com.codecool.customers;

import com.codecool.customers.Customer;
import com.codecool.customers.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository testedCustomerRepository;

    @Test
    void shouldReadCustomersFromDb() {
        // when:
        List<Customer> actual = testedCustomerRepository.findAll();

        // then:
        Assertions.assertThat(actual).hasSize(2);

        List<String> actualNames = List.of(actual.get(0).getFullName(), actual.get(1).getFullName());
        List<String> actualEmails = List.of(actual.get(0).getEmail(), actual.get(1).getEmail());

        Assertions.assertThat(actualNames).isEqualTo(List.of("John Doe", "Jane Doe"));
        Assertions.assertThat(actualEmails).isEqualTo(List.of("john.doe@example.com", "jane.doe@example.com"));
    }

    @Test
    void shouldFindCustomerById() {
        // when:
        UUID customerId = UUID.fromString("d063ff50-00a1-4f96-94f9-a4fb31d33e76");
        Optional<Customer> actual = testedCustomerRepository.findById(customerId);

        // then:
        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get().getFullName()).isEqualTo("Jane Doe");
        Assertions.assertThat(actual.get().getEmail()).isEqualTo("jane.doe@example.com");
    }

    @Test
    void shouldNotReturnNonExistentCustomer() {
        // when:
        UUID nonExistentCustomerId = UUID.randomUUID();
        Optional<Customer> actual = testedCustomerRepository.findById(nonExistentCustomerId);

        // then:
        Assertions.assertThat(actual).isEmpty();
    }
}
