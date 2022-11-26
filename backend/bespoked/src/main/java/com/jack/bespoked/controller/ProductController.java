package com.jack.bespoked.controller;

import com.jack.bespoked.entity.Product;
import com.jack.bespoked.repository.ProductRepository;
import com.jack.bespoked.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path="")
    public Response createProduct(@RequestBody Product product) {
        Product current = productRepository.findByName(product.getName());
        if (current != null && current.getId() != product.getId()) {
            return new Response("Product already exists", null);
        }
        Product newProduct = productRepository.save(product);
        return new Response("Success", newProduct);
    }

    @GetMapping(path="")
    public Response getProducts() {

        Iterator<Product> productIterator = productRepository.findAll().iterator();
        List<Product> products = new ArrayList<>();
        while (productIterator.hasNext()) {
            products.add(productIterator.next());
        }
        return new Response("Success", products);
    }

}