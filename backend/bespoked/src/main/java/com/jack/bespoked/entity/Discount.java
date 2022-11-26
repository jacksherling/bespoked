package com.jack.bespoked.entity;

import javax.persistence.*;

@Entity
public class Discount {

    public Discount() {
        super();
    }

    public Discount(Product product, String beginDate, String endDate, double discountPercentage) {
        this.product = product;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_foreign_key", referencedColumnName = "id")
    private Product product;
    private String beginDate;
    private String endDate;
    private double discountPercentage;

    public Integer getId() {
        return this.id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

}
