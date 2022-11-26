package com.jack.bespoked.controller;

import com.jack.bespoked.entity.*;
import com.jack.bespoked.repository.DiscountRepository;
import com.jack.bespoked.repository.ProductRepository;
import com.jack.bespoked.repository.SaleRepository;
import com.jack.bespoked.repository.SalespersonRepository;
import com.jack.bespoked.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/sale")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @PostMapping(path="")
    public Response createSale(@RequestBody Sale sale) {
        List<Discount> discounts = discountRepository.findDiscounts(sale.getProduct().getId(), sale.getSalesDate());
        double discount = 1;
        for (Discount d : discounts) {
            discount -= d.getDiscountPercentage();
        }
        sale.setPrice(sale.getProduct().getPurchasePrice() * discount);
        Sale newSale = saleRepository.save(sale);
        return new Response("Success", newSale);
    }

    @GetMapping(path="")
    public Response getSales() {
        Iterator<Sale> salesIterator = saleRepository.findAll().iterator();
        List<Sale> sales = new ArrayList<>();
        while (salesIterator.hasNext()) {
            sales.add(salesIterator.next());
        }
        return new Response("Success", sales);
    }

}