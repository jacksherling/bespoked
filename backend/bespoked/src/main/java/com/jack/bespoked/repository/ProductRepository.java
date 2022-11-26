package com.jack.bespoked.repository;

import com.jack.bespoked.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByName(String name);

}