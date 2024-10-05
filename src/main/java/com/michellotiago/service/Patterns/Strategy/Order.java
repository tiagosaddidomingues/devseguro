package com.michellotiago.service.Patterns.Strategy;

public class Order{
    private double weight;
    private IShippingStrategy IShippingStrategy;

    public Order(double weight, IShippingStrategy strategy) {
        this.weight = weight;
        this.IShippingStrategy = strategy;
    }

    public double getWeight() {
        return weight;
    }
    public void setShippingStragegy(IShippingStrategy strategy){
        IShippingStrategy = strategy;
    }
    public double calculateShipping(){
        return IShippingStrategy.calculateShippingCost(this);
    }
}