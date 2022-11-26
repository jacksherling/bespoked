package com.jack.bespoked.controller;

import com.jack.bespoked.entity.*;
import com.jack.bespoked.repository.SaleRepository;
import com.jack.bespoked.repository.SalespersonRepository;
import com.jack.bespoked.util.Quarter;
import com.jack.bespoked.util.QuarterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/report")
public class ReportController {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SalespersonRepository salespersonRepository;

    @PostMapping(path="")
    public QuarterResponse getReport(@RequestBody Quarter quarter) {
        String month1 = formattedMonth((quarter.getQuarter() - 1) * 3 + 1);
        String month2 = formattedMonth(quarter.getQuarter() * 3);
        String date1 = quarter.getYear() + "-" + month1 + "-00";
        String date2 = quarter.getYear() + "-" + month2 + "-32";
        List<Sale> sales = saleRepository.getSaleByQuarter(date1, date2);
        List<Salesperson> salespeople = salespersonRepository.getSalespeopleByQuarter(date1, date2);
        return new QuarterResponse("Success", salespeople, sales);
    }

    private String formattedMonth(int month) {
        return (month < 10 ? "0" : "") + month;
    }

}