package com.michellotiago.repository.pedido.dao;

import com.michellotiago.repository.pedido.dto.Pedido;

public interface IPedidoDAO {
	
	void create(Pedido pedido);
	
	Pedido read(int id);
	
	void update(Pedido pedido);
	
	void delete (int id);

}
