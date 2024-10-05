package com.michellotiago.service.Patterns.FactoryMethod;

public class PostgreSQLFactory extends DatabaseFactory{
    public IDatabase createDatabase(){
        return new PostgreSQL();
    }
}