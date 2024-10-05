package com.michellotiago.repository.cliente.dao;

import com.michellotiago.repository.cliente.dto.Cliente;

public interface IClienteDAO {
	
	void create(Cliente cliente);
	
	Cliente read(int id);
	
	void update(Cliente cliente);
	
	void delete (int id);
}
