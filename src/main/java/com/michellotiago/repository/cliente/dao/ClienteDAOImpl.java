package com.michellotiago.repository.cliente.dao;

import java.util.HashMap;
import java.util.Map;

import com.michellotiago.repository.cliente.dto.Cliente;

public class ClienteDAOImpl implements IClienteDAO {

	Map<Integer, Cliente> clientes = new HashMap<>();

	public ClienteDAOImpl(){

		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Tiago");
		cliente.setSenha("11111");
		cliente.setTelefone("(061-55555-5555");
		cliente.seteMail("tiago.saddi@gmail.com");
		cliente.setEndereco("SQSW 107 Bloco W Apartamento 1021, Sudoeste, Brasília, DF, 70.998-869");
		cliente.setPromocao(false);
		clientes.put(1,cliente);

		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNome("Michello");
		cliente2.setSenha("22222");
		cliente2.setTelefone("(061-44444-44444");
		cliente2.seteMail("michello@gmail.com");
		cliente2.setEndereco("QLN 20 Conjunto z casa 48, Lago Norte, Brasília, DF, 70978-232");
		cliente2.setPromocao(true);
		clientes.put(2,cliente2);

		Cliente cliente3 = new Cliente();
		cliente3.setId(3);
		cliente3.setNome("Alan");
		cliente3.setSenha("33333");
		cliente3.setTelefone("(061-33333-3333");
		cliente3.setEndereco("SQN 118 Bloco x apartamento 733, Asa Norte, Brasília, DF, 70878-278");
		cliente3.seteMail("alan@gmail.com");
		cliente3.setPromocao(true);
		clientes.put(3,cliente3);
	}
	@Override
	public void create(Cliente cliente) {

		clientes.put(cliente.getId(), cliente);
	}

	@Override
	public Cliente read(int id) {
		return clientes.get(id);
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}
	public Cliente findByNameAndSenha(String nome, String senha) {
		for (Cliente cliente: clientes.values()){
			if (cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)){
				return cliente;
			}
		}
		return null;
	}
}
