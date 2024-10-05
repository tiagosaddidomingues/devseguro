package com.michellotiago.service.Patterns.FactoryMethod;

public abstract class DatabaseFactory {
    public abstract IDatabase createDatabase();

    public static DatabaseFactory getFactory(String type){
        if (type == "PostgreSQL")
            return new PostgreSQLFactory();
        if (type == "MySQL")
            return new MySQLFactory();
        return null;

    }
}
