package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query: find by email domain
    List<Customer> findByEmailEndingWith(String domain);

    // Custom query: find by phone prefix
    List<Customer> findByPhoneNumberStartingWith(String prefix);
}
