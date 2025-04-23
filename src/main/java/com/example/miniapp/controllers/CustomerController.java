package com.example.miniapp.controllers;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import com.example.miniapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    @GetMapping("/")
    public List<Customer> getAllCustomers() {
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
    public String deleteCustomer(@PathVariable Long id){
        if(!(customerService.getCustomerById(id)== null)){
            customerService.deleteCustomer(id);
            return "Customer deleted";
        }
        else {
            return "Customer not found";
        }
    }
    @GetMapping("/findByEmailDomain")
    public List<Customer> findCustomersByEmailDomain(@RequestParam String domain){
        return customerService.findCustomersByEmailDomain(domain);
    }
    @GetMapping("/findByPhonePrefix")
    public List<Customer> findCustomersByPhonePrefix(@RequestParam String phonePrefix){
        return customerService.findCustomersByPhonePrefix(phonePrefix);
    }


}
