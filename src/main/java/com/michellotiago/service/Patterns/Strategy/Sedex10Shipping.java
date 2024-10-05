package com.michellotiago.service.Patterns.Strategy;

public class Sedex10Shipping implements IShippingStrategy {

    public double calculateShippingCost(Order order){
        return order.getWeight()* 3.00;
    }
}
