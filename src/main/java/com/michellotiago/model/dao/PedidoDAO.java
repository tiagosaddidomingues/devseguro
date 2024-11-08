package com.michellotiago.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;

import com.michellotiago.model.Cliente;
import com.michellotiago.model.Produto;

public class PedidoDAO {

	private Conexao conexao;

	public PedidoDAO() {
		conexao = Conexao.getConexao();
	}


	public void saveAll(List<Produto> produtosCompra, Cliente cliente) {
		if (cliente == null || cliente.getId() == 0) {
			System.err.println("Erro: Cliente inválido para salvar o pedido.");
			return;
		}

		LocalDate data = LocalDate.now();
		String query = "INSERT INTO stj.pedido (id_cliente, id_produto, quantidade, preco_unitario, data_compra) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conexao.getConnection().prepareStatement(query)) {
			for (Produto produto : produtosCompra) {
				if (cliente.getId() <= 0 || produto.getId() <= 0) {
					System.err.println("Erro: ID inválido para cliente ou produto.");
					continue;
				}

				ps.setInt(1, cliente.getId());
				ps.setInt(2, produto.getId());
				ps.setInt(3, produto.getQuantidade());

				BigDecimal preco = BigDecimal.valueOf(produto.getPreco());
				ps.setBigDecimal(4, preco);
				ps.setDate(5, Date.valueOf(data));
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("Pedidos salvos com sucesso!");
		} catch (SQLException ex) {
			System.err.println("Erro ao salvar pedidos no banco de dados.");
			ex.printStackTrace();
		}
	}



}
