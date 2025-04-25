package com.example.miniapp.controllers;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import com.example.miniapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
    @GetMapping("/allCustomers")
    public List<Customer> allCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        // Always return 200 OK, even if customer doesn't exist
        customerService.deleteCustomer(id); // Service should handle non-existent case
        return "Customer deleted";
    }
    @GetMapping("/findByEmailDomain")
    public List<Customer> findCustomersByEmailDomain(@RequestParam String domain){
        return customerService.findCustomersByEmailDomain(domain);
    }


    @GetMapping("/findByPhonePrefix")
    public ResponseEntity<List<Customer>> findByPhonePrefix(
        @RequestParam(value = "prefix", required = true) String phonePrefix) {
        return ResponseEntity.ok(customerService.findCustomersByPhonePrefix(phonePrefix));
    }


}
