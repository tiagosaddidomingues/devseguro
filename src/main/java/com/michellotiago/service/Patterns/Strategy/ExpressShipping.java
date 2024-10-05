package com.michellotiago.service.Patterns.Strategy;

public class ExpressShipping implements IShippingStrategy {

    public double calculateShippingCost(Order order){
        return order.getWeight()* 2.50;
    }
}