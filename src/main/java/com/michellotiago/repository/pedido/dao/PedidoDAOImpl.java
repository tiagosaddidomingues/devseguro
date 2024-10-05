package com.michellotiago.repository.pedido.dao;

import java.util.HashMap;
import java.util.Map;

import com.michellotiago.repository.pedido.dto.Pedido;

public class PedidoDAOImpl implements IPedidoDAO {

	Map<Integer, Pedido> pedidos = new HashMap<>();
	
	public PedidoDAOImpl(){

	}
	@Override
	public void create(Pedido pedido) {

		pedidos.put(pedido.getId(),pedido);
	}

	@Override
	public Pedido read(int id) {
		return pedidos.get(id);
	}

	@Override
	public void update(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
