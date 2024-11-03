package com.michellotiago.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.michellotiago.model.Cliente;
import com.michellotiago.model.Pedido;
import com.michellotiago.model.Produto;

public class PedidoDAO {

	private Conexao conexao;
	public PedidoDAO() {
		conexao = Conexao.getConexao();
	}

	public void saveAll(List<Produto> produtosCompra, Cliente cliente) {
		LocalDate data = LocalDate.now();
		String query = "INSERT INTO stj.pedido (id_cliente,id_produto,quantidade,preço_unitario,data_compra)"+
				" VALUES ";
		for (Produto produto : produtosCompra) {
			query += "(" + cliente.getId() + "," + produto.getId() + "," + produto.getQuantidade() + ","
					+ produto.getPreco() + "," + data + ")" + ", ";

			query = query.substring(0, query.length()-2);
			try (PreparedStatement preparedStatements = conexao.getConnection().prepareStatement(query)) {
				preparedStatements.executeUpdate();
				//preparedStatements.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
}