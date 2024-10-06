package com.michellotiago.service.Patterns.FactoryMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL extends DatabaseFactory implements IDatabase {
    private static MySQL conexao;
    private String jdbc;
    private String usuario;
    private String senha;
    private Connection con;

    public  void connect(){
        System.out.println("Connecting to MySQL database.");
        usuario = "admin";
        senha = "admin";
        jdbc = "jdbc:mysql://localhost:3306/stj?useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbc, usuario, senha);
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    public MySQL createDatabase() {
        if(conexao == null) {
            conexao = new MySQL();
        }
        return conexao;
    }
}