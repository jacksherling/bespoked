package com.jack.bespoked.controller;

import com.jack.bespoked.entity.Customer;
import com.jack.bespoked.repository.CustomerRepository;
import com.jack.bespoked.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="")
    public Response createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return new Response("Success", newCustomer);
    }

    @GetMapping(path="")
    public Response getCustomers() {
        Iterator<Customer> customerIterator = customerRepository.findAll().iterator();
        List<Customer> customers = new ArrayList<>();
        while (customerIterator.hasNext()) {
            customers.add(customerIterator.next());
        }
        return new Response("Success", customers);
    }

}