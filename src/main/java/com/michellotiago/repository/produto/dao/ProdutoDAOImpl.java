package com.michellotiago.repository.produto.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.michellotiago.repository.produto.dto.Produto;

public class ProdutoDAOImpl implements IProdutoDAO {


	Map<Integer, Produto> produtos = new HashMap<>();

	private int id;
	String nome;
	private String descricao;
	private int preco;
	public ProdutoDAOImpl(){
		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Casaco");
		produto.setDescricao("Casaco de frio");
		produto.setPreco(123.20f);
		produto.setQuantidade(5);
		produto.setPeso(1.0f);
		produtos.put(1,produto);

		Produto produto2 = new Produto();
		produto2.setId(2);
		produto2.setNome("Blusa");
		produto2.setDescricao("Blusa de linho");
		produto2.setPreco(211.10f);
		produto2.setQuantidade(5);
		produtos.put(2,produto2);

		Produto produto3 = new Produto();
		produto3.setId(3);
		produto3.setNome("Cueca");
		produto3.setDescricao("Cueca de algodão");
		produto3.setPreco(32.20f);
		produto3.setQuantidade(5);
		produto3.setPeso(0.2f);
		produtos.put(3,produto3);

		Produto produto4 = new Produto();
		produto4.setId(4);
		produto4.setNome("sandália");
		produto4.setDescricao("sandalia de couro");
		produto4.setPreco(101.20f);
		produto4.setQuantidade(5);
		produto4.setPeso(0.5f);
		produtos.put(4,produto4);

		Produto produto5 = new Produto();
		produto5.setId(5);
		produto5.setNome("lenço");
		produto5.setDescricao("lenço de seda");
		produto5.setPreco(200.20f);
		produto5.setQuantidade(5);
		produto5.setPeso(0.1f);
		produtos.put(5,produto5);

	}

	public void inserir(Produto produto) {
		this.produtos.put(produto.getId(),produto);
	}

	@Override
	public void create(Produto produto) {
	}

	@Override
	public Produto read(int id) {
		return produtos.get(id);
	}

	@Override
	public void update(Produto produto) {

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}
	public List<Produto> getAll(){
		List<Produto> produtoss = new ArrayList<>();

		for (Produto produto: produtos.values()){
				produtoss.add(produto);
			}
		return produtoss;

	}
	public Produto findByIDAndQuatidade(int id, int quantidade) {
		Produto produto = produtos.get(id);
		if (produto==null){
			System.out.println("Produto Inexistente");
			return null;
		}
		if (produto.getQuantidade()<quantidade){
			System.out.println("Quantidade de Produto insuficiente em estoque");
			return null;
		}
		return produto;
		}

	}
