package com.michellotiago.model.dao;

import com.michellotiago.model.Cliente;
import com.michellotiago.util.Seguranca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteDAO {

	private Conexao conexao;
	private String query;

	public ClienteDAO() {
		conexao = Conexao.getConexao();
	}

	public void inserirCliente(Cliente cliente) {
		query = "INSERT INTO stj.cliente (nome, senha, eMail, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
			ps.setString(1, cliente.getNome());
			ps.setString(2, Seguranca.hashMD5(cliente.getSenha()));
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, cliente.getEndereco());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao inserir cliente no banco de dados.");
		}
	}

	public boolean atualizarCliente(Cliente cliente) {
		query = "UPDATE stj.cliente SET nome = ?, senha = ?, eMail = ?, telefone = ?, endereco = ? WHERE id_cliente = ?";
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
			ps.setString(1, cliente.getNome());
			ps.setString(2, Seguranca.hashMD5(cliente.getSenha()));
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, cliente.getEndereco());
			ps.setInt(6, cliente.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar cliente no banco de dados.");
			return false;
		}
	}

	public boolean excluirCliente(int id) {
		query = "DELETE FROM stj.cliente WHERE id_cliente = ?";
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao excluir cliente no banco de dados.");
			return false;
		}
	}

	public Cliente findByNameAndSenha(String nome, String senha) {
		validarEntrada(nome);
		query = "SELECT id_cliente, nome, senha, eMail, telefone, endereco FROM stj.cliente WHERE nome = ? AND senha = ?";

		System.out.println("Iniciando autenticação para usuário: " + nome);

		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
			ps.setString(1, nome);

			// Aplica o hash à senha para comparar com o banco de dados
			String hashedSenha = Seguranca.hashMD5(senha);
			System.out.println("Hash da senha inserida: " + hashedSenha);

			ps.setString(2, hashedSenha);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println("Usuário autenticado com sucesso!");

					Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("senha"));
					cliente.setId(rs.getInt("id_cliente"));
					cliente.setEmail(rs.getString("eMail"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEndereco(rs.getString("endereco"));

					return cliente;
				} else {
					System.out.println("Nenhum usuário encontrado com as credenciais fornecidas.");
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar cliente no banco de dados.");
			e.printStackTrace();
		}
		return null;
	}

	private void validarEntrada(String texto) {
		if (texto == null || texto.isEmpty()) {
			throw new IllegalArgumentException("Input não pode ser nulo ou vazio.");
		}
		String inputNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFKC);
		Pattern padrao = Pattern.compile("[<>]");
		Matcher matcher = padrao.matcher(inputNormalizado);
		if (matcher.find()) {
			throw new IllegalArgumentException("Caracteres inválidos detectados.");
		}
	}
}
