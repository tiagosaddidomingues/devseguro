package com.michellotiago.model.dao;

/**
 * @author $ {USER}
 **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Conexao conexao;
    private String jdbc;
    private String usuario;
    private String senha;
    private Connection con;

    private Conexao() {
        usuario = System.getenv("DB_USUARIO");
        senha = System.getenv("DB_SENHA");
        jdbc = "jdbc:mysql://127.0.0.1:3306/stj?useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbc, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    public static Conexao getConexao() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() {
        return this.con;
    }
}