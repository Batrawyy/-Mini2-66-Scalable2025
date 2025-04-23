package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer with ID " + id + " not found"
                ));
    }
    public Customer updateCustomer(long id, Customer updatedData) {

        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No customer " + id));

        updatedData.setId(id);
        return customerRepository.save(updatedData);
    }
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("Customer " + id + " not found");
        }
        customerRepository.deleteById(id);
    }
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailEndingWith(domain);
    }
    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);

    }
}
