package com.michellotiago.model;

public class Cliente {
	private int id;
	private String nome;
	private String senha;
	private String email;  // Alterado para email em vez de eMail, seguindo a convenção de nomenclatura
	private String telefone;
	private String endereco;
	private boolean promocao;

	public Cliente(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Altere o nome do método para getEmail
	public String getEmail() {
		return email;
	}

	// Altere o nome do método para setEmail
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
