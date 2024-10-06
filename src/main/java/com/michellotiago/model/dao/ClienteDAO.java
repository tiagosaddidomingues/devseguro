package com.michellotiago.model.dao;

import com.michellotiago.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

	private Conexao conexao;
	private Cliente cliente;

	public boolean retornarIgualdadeDeStrings(String nome1, String nome2){
		return nome1.equals(nome2);
	}
	public ClienteDAO() {
		conexao = Conexao.getConexao();
	}

	public void inserirCliente(Cliente u) {
		String query = "INSERT INTO stj.cliente (nome, senha) VALUES (?, ?)";
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query);) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getSenha());
			ps.executeUpdate();
			ps.close();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public Cliente findByNameAndSenha(String nome, String senha) {
		ClienteDAO clienteDao = new ClienteDAO();
		String query = "SELECT nome,senha FROM STJ.CLIENTE where nome = ? and senha = ?";
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query);) {
			ps.setString(1, nome);
			ps.setString(2, senha);
			ResultSet rst = ps.executeQuery();
			rst.next();
            cliente = new Cliente(rst.getString(1),rst.getString(2));
            return cliente;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Cliente getCliente() {
		return cliente;
	}
}
