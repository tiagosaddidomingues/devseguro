package com.michellotiago.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.michellotiago.model.Produto;

public class ProdutoDAO  {

	private int id;
	String nome;
	private String descricao;
	private int preco;
	public List<Produto> findAll(){
		List<Produto> produtos = new ArrayList<>();
		String query = "SELECT produto.id_produto, produto.nome, produto.descricao, produto.preco," +
				"produto.peso,produto`.`quantidade" +
				" FROM stj.produto";
		try (PreparedStatement ps = Conexao.getConexao().getConnection().prepareStatement(query)){
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setNome(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setPreco(rs.getFloat(4));
				produto.setPeso(rs.getFloat(5));
				produto.setQuantidade(rs.getInt(6));
				produtos.add(produto);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			produtos.clear();
		}
		return produtos;
	}

	public Produto findByIDAndQuatidade(int id, int quantidade) {
		String query = "SELECT produto.id_produto, produto.nome, produto.descricao, produto.preco," +
				"produto.peso,produto`.`quantidade" +
				" FROM stj.produto";
		try (PreparedStatement ps = Conexao.getConexao().getConnection().prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			//rs.next();
			Produto produto = new Produto();
			produto.setNome(rs.getString(2));
			produto.setDescricao(rs.getString(3));
			produto.setPreco(rs.getFloat(4));
			produto.setPeso(rs.getFloat(5));
			produto.setQuantidade(rs.getInt(6));
			if (produto == null) {
				System.out.println("Produto Inexistente");
				return null;
			}
			if (produto.getQuantidade() < quantidade) {
				System.out.println("Quantidade de Produto insuficiente em estoque");
				return null;
			}
			return produto;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
        return null;
    }

}
