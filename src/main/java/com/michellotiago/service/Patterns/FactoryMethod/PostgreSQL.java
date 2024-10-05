package com.michellotiago.service.Patterns.FactoryMethod;

public class PostgreSQL implements IDatabase {
    public void connect(){
        System.out.println("Connecting to PostgreSQL database.");
    }
}