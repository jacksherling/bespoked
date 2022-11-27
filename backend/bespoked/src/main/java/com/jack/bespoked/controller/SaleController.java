package com.jack.bespoked.controller;

import com.jack.bespoked.entity.*;
import com.jack.bespoked.repository.*;
import com.jack.bespoked.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="")
    public Response createSale(@RequestBody Sale sale) throws ParseException {
        Product product = productRepository.findById(sale.getProduct().getId()).orElse(null);
        if (product == null || product.getQtyOnHand() <= 0) {
            return new Response("No product in stock", null);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date saleDate = dateFormat.parse(sale.getSalesDate());

        Salesperson salesperson = salespersonRepository.findById(sale.getSalesperson().getId()).orElse(null);
        if (salesperson != null) {
            Date start = dateFormat.parse(salesperson.getStartDate());
            Date termination = dateFormat.parse(salesperson.getTerminationDate());
            if (start.compareTo(saleDate) > 0 || termination.compareTo(saleDate) < 0) {
                return new Response("Salesperson not present at this date", null);
            }
        }

        Customer customer = customerRepository.findById(sale.getCustomer().getId()).orElse(null);
        if (customer != null) {
            Date from = dateFormat.parse(customer.getStartDate());
            if (from.compareTo(saleDate) > 0) {
                return new Response("Customer not present at this date", null);
            }
        }

        List<Discount> discounts = discountRepository.findDiscounts(sale.getProduct().getId(), sale.getSalesDate());
        double discount = 1;
        for (Discount d : discounts) {
            discount -= d.getDiscountPercentage();
        }
        sale.setPrice(sale.getProduct().getPurchasePrice() * discount);
        Sale newSale = saleRepository.save(sale);

        product.setQtyOnHand(product.getQtyOnHand() - 1);
        productRepository.save(product);

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