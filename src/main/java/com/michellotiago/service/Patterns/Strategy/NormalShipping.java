package com.michellotiago.service.Patterns.Strategy;

public class NormalShipping implements IShippingStrategy {

    public double calculateShippingCost(Order order){
        return order.getWeight()* 1.00;
    }
}