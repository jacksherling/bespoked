package com.jack.bespoked.controller;

import com.jack.bespoked.entity.Discount;
import com.jack.bespoked.repository.DiscountRepository;
import com.jack.bespoked.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/discount")
public class DiscountController {

    @Autowired
    private DiscountRepository discountRepository;

    @PostMapping(path="")
    public Response createDiscount(@RequestBody Discount discount) {
        Discount newDiscount = discountRepository.save(discount);
        return new Response("Success", discount);
    }

    @GetMapping(path="")
    public Response getDiscounts() {
        Iterator<Discount> discountsIterator = discountRepository.findAll().iterator();
        List<Discount> discounts = new ArrayList<>();
        while (discountsIterator.hasNext()) {
            discounts.add(discountsIterator.next());
        }
        return new Response("Success", discounts);
    }

}