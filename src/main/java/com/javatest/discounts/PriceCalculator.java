package com.javatest.discounts;

import java.util.*;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {
        double result =0;
        for (Double price: prices){
            result +=price;
        }
        return result * ((100 - discount) / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiiscount(double discount) {
        this.discount = discount;
    }
}
