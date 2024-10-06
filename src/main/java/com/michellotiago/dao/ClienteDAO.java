package com.michellotiago.dao;

import java.util.ArrayList;
import java.util.List;

import com.michellotiago.entity.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

	private Conexao conexao;

	public boolean retornarIgualdadeDeStrings(String nome1, String nome2){
		return nome1.equals(nome2);
	}
	public ClienteDAO() {
		conexao = Conexao.getConexao();
	}

	public void inserirCliente(Cliente u) {
		try {
			PreparedStatement ps;
			String query = "INSERT INTO usuario (nome, senha) VALUES (?, ?)";
			ps = conexao.getConnection().prepareStatement(query);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getSenha());
			ps.executeUpdate();
			ps.close();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
