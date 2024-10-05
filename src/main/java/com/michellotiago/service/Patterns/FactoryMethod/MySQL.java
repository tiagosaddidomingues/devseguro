package com.michellotiago.service.Patterns.FactoryMethod;

public class MySQL implements IDatabase {
    public void connect(){
        System.out.println("Connecting to MySQL database.");
    }
}