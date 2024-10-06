package com.michellotiago.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.michellotiago.model.Produto;

public class ProdutoDAO  {

	List <Produto> produtos = new ArrayList<>();

	private int id;
	String nome;
	private String descricao;
	private int preco;
	public ProdutoDAO(){

	}


	public void create(Produto produto) {
	}

	public Produto read(int id) {
		return produtos.get(id);
	}

	public void update(Produto produto) {

		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
	}
	public List<Produto> getAll(){
		List<Produto> produtoss = new ArrayList<>();

		for (Produto produto: produtos){
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
