package com.michellotiago.model.dto;

public class ProdutoDTO {
	private int id;
	String nome;
	private String descricao;
	private int preco;

	public int getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
}
