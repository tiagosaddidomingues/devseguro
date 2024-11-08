package com.michellotiago.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.michellotiago.model.Produto;

public class ProdutoDAO {

	private int id;
	String nome;
	private String descricao;
	private int preco;

	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<>();
		String query = "select id_produto, nome, descricao, preco, peso, quantidade from stj.produto";
		try (PreparedStatement ps = Conexao.getConexao().getConnection().prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id_produto"));          // Usando o nome da coluna
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setPeso(rs.getFloat("peso"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produtos.add(produto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			produtos.clear();
		}
		return produtos;
	}

	public Produto findByIDAndQuatidade(int id, int quantidade) {
		String query = "select id_produto, nome, descricao, preco, peso, quantidade from stj.produto where id_produto = ?";
		try (PreparedStatement ps = Conexao.getConexao().getConnection().prepareStatement(query)) {
			ps.setInt(1, id); // Definindo o parâmetro de ID para a consulta
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {  // Verificar se há um resultado
				Produto produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setPeso(rs.getFloat("peso"));
				produto.setQuantidade(rs.getInt("quantidade"));

				if (produto.getQuantidade() < quantidade) {
					System.out.println("Quantidade de Produto insuficiente em estoque");
					return null;
				}
				return produto;
			} else {
				System.out.println("Produto Inexistente");
				return null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
