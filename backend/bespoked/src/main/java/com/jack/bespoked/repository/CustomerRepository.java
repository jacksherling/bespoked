package com.jack.bespoked.repository;

import com.jack.bespoked.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}