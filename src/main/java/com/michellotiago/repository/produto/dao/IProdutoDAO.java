package com.michellotiago.repository.produto.dao;

import com.michellotiago.repository.produto.dto.Produto;

public interface IProdutoDAO {
	
void create(Produto produto);
	
	Produto read(int id);
	
	void update(Produto product);
	
	void delete (int id);
}
