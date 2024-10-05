package com.michellotiago.service.Patterns.FactoryMethod;

class MySQLFactory extends DatabaseFactory{
    public IDatabase createDatabase(){
        return new MySQL();
    }
}