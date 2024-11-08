package com.michellotiago.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Conexao conexao;
    private String jdbc;
    private String usuario;
    private String senha;
    private Connection con;

    public Conexao() {
        usuario = System.getenv("DB_USUARIO");
        senha = System.getenv("DB_SENHA");

        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalStateException("Erro: A variável de ambiente DB_USUARIO não está definida.");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalStateException("Erro: A variável de ambiente DB_SENHA não está definida.");
        }

        jdbc = "jdbc:mysql://192.168.1.54:3306/stj?useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbc, usuario, senha);
            con.setAutoCommit(true);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro: Falha ao conectar ao banco de dados.");
            e.printStackTrace();
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
