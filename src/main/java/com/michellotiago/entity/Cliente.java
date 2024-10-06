package com.michellotiago.entity;

public class Cliente {
	private int id;

	public Cliente(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	String nome;
	String senha;
	private String eMail;
	private String telefone;
	private String endereco;
	private boolean promocao;
	
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isPromocao() {return promocao;}
	public void setPromocao(boolean promocao) {	this.promocao = promocao;}
	public String getEndereco() { return endereco;}
	public void setEndereco(String endereco) { this.endereco = endereco;}

}
