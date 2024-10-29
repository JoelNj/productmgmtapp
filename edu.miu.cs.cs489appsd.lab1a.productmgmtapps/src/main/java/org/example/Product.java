package org.example;

import java.math.BigInteger;
import java.time.LocalDate;

public class Product {


    private BigInteger prodcutId;

    private String name;

    private LocalDate dateSupplied;

    private int quantityInStock;

    private double unitPrice;

    public void setName(String name) {
        this.name = name;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getProdcutId() {
        return prodcutId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Product(String name, LocalDate dateSupplied, int quantityInStock, double unitPrice) {
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product() {

    }

    public Product(BigInteger prodcutId, String name, LocalDate dateSupplied, int quantityInStock, double unitPrice) {
        this.prodcutId = prodcutId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }
}
