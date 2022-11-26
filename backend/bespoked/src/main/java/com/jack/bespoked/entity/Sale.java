package com.jack.bespoked.entity;

import javax.persistence.*;

@Entity
public class Sale {

    public Sale() {
        super();
    }

    public Sale(Product product, Salesperson salesperson, Customer customer, String salesDate, double price) {
        this.product = product;
        this.salesperson = salesperson;
        this.customer = customer;
        this.salesDate = salesDate;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_foreign_key", referencedColumnName = "id")
    private Product product;
    @OneToOne(targetEntity = Salesperson.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "salesperson_foreign_key", referencedColumnName = "id")
    private Salesperson salesperson;
    @OneToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_foreign_key", referencedColumnName = "id")
    private Customer customer;
    private String salesDate;
    private double price;

    public Integer getId() {
        return this.id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesPerson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

}
