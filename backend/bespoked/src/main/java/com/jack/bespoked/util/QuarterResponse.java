package com.jack.bespoked.util;

import com.jack.bespoked.entity.Sale;
import com.jack.bespoked.entity.Salesperson;

import java.util.List;

public class QuarterResponse {

    private String message;
    private List<Salesperson> salespeople;
    private List<Sale> sales;

    public QuarterResponse(String message, List<Salesperson> salespeople, List<Sale> sales) {
        this.message = message;
        this.salespeople = salespeople;
        this.sales = sales;
    }

    public String getMessage() {
        return this.message;
    }

    public List<Salesperson> getSalespeople() {
        return this.salespeople;
    }

    public List<Sale> getSales() {
        return this.sales;
    }

}