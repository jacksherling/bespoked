package com.jack.bespoked.controller;

import com.jack.bespoked.entity.JoinedSale;
import com.jack.bespoked.entity.Salesperson;
import com.jack.bespoked.repository.ProductRepository;
import com.jack.bespoked.repository.SalespersonRepository;
import com.jack.bespoked.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/salesperson")
public class SalespersonController {

    @Autowired
    private SalespersonRepository salespersonRepository;

    @PostMapping(path="")
    public Response createSalesperson(@RequestBody Salesperson salesperson) {
        Salesperson current = salespersonRepository.findByFirstNameAndLastName(salesperson.getFirstName(), salesperson.getLastName());
        if (current != null && current.getId() != salesperson.getId()) {
            return new Response("Salesperson already exists", null);
        }
        Salesperson newSalesperson = salespersonRepository.save(salesperson);
        return new Response("Success", newSalesperson);
    }

    @GetMapping(path="")
    public Response getSalespeople() {
        Iterator<Salesperson> salespersonIterator = salespersonRepository.findAll().iterator();
        List<Salesperson> salespeople = new ArrayList<>();
        while (salespersonIterator.hasNext()) {
            salespeople.add(salespersonIterator.next());
        }
        return new Response("Success", salespeople);
    }

}